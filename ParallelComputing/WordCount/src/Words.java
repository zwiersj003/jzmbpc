import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by konin on 31-3-2016.
 */


class Counter implements Runnable {

    public String[] text;
    public HashMap<String, Integer> wordCount;

    public Counter(String[] text) {
        this.text = text;
    }

    @Override
    public void run() {
        wordCount = Words.countWords(text);
    }
}

class RangedCounter extends Counter {

    public int from, till;
    public HashMap<String, Integer> totalCount = null;

    public RangedCounter(String[] text, int from, int till, HashMap<String, Integer> totalCount) {
        super(text);
        this.from = from;
        this.till = till;
        this.totalCount = totalCount;
    }

    @Override
    public void run() {
        wordCount = Words.countWordsInRange(text, from, till);

        if (totalCount != null) {
            Words.UpdateCounts(totalCount, wordCount);
        }
    }
}


class Producer implements Runnable {

    private BlockingQueue<Page> queue;

    public Producer(BlockingQueue<Page> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        String fileName = "d:\\temp\\tiny.txt";

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

            Page p = new Page();

            String line = null;
            while ((line = reader.readLine()) != null) {
                p.list.add(line);

                // 100 words per page
                if (p.list.size() == 100) {
                    try {
                        queue.put(p);
                        p = new Page();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            // flush the remaining page if it contains words
            if (p.list.size()>0) {
                try {
                    queue.put(p);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Consumer implements Runnable {

    private BlockingQueue<Page> queue;


    public Consumer(BlockingQueue<Page> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Consuming a page");
                Page p = queue.take();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}


class Page {
    public ArrayList<String> list = new ArrayList<>();
}




public class Words {

    public static String[] getSmallDictionary(){
        return new String[]{"purple", "orange", "silver",  "people", "family"};
    }
    // each word in the dictionary is added count times
    public static String[] generateText(String[] dictionary, int count) {
        String[] result = new String[dictionary.length * count];

        int j = -1;
        for (String s: dictionary) {
            for (int i = 1; i <= count; i++) {
                j++;
                result[j] = s;
            }
        }

        return result;
    }
    // source: http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    // Implementing Fisher�Yates shuffle
    public static void shuffle(String[] text) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = text.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = text[index];
            text[index] = text[i];
            text[i] = a;
        }
    }
    public static void writeTextToFile(String[] text, String filename) {


        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));

            for (String word: text) {
                writer.write(word);
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String[] readTextFromFile(String filename) {

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filename));

            ArrayList<String> al = new ArrayList<String>();

            String line = null;
            while ((line = reader.readLine()) != null) {
                al.add(line);
            }
            reader.close();
            String[] text = al.toArray(new String[al.size()]);
            return text;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
    public static HashMap<String, Integer> countWords(String[] text) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (String word: text) {

            Integer currentCount = result.get(word);
            if (currentCount == null)
                result.put(word, 1);
            else
                result.put(word, currentCount + 1);

        }
        return result;
    }
    public static HashMap<String, Integer> countWordsInRange(String[] text, int from, int till) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (int i = from; i < till; i++) {
            String word = text[i];

            Integer currentCount = result.get(word);
            if (currentCount == null)
                result.put(word, 1);
            else
                result.put(word, currentCount + 1);
        }

        return result;
    }
    public static void solveUsingSerialAlgorithm(String[] text){
        EventProfiler profiler = new EventProfiler(true);
        profiler.start();
        HashMap<String, Integer> wordCounts = countWords(text);
        profiler.log("Serial         " + wordCounts.toString());
    }
    public static void SolveUsingOneThread(String[] text) throws InterruptedException {
        EventProfiler profiler = new EventProfiler(true);

        profiler.start();

        Counter counter = new Counter(text);
        Thread counterThread = new Thread(counter);

        counterThread.start();
        counterThread.join();

        profiler.log(counter.wordCount.toString());
    }
    public static void SolveUsingTwoThreads(String[] text) throws InterruptedException {
        EventProfiler profiler = new EventProfiler(true);

        profiler.start();

        int middle = text.length/2;
        String[] leftPart = Arrays.copyOfRange(text, 0, middle);
        String[] rightPart = Arrays.copyOfRange(text, middle+1, text.length);

//        EventProfiler.mark("    Splitting text");

//        System.out.println(leftPart.size() + "," + rightPart.size());

        // create 2 counters
        Counter leftCounter = new Counter(leftPart);
        Counter rightCounter = new Counter(rightPart);

        // and 2 threads
        Thread t1 = new Thread(leftCounter);
        Thread t2 = new Thread(rightCounter);

        t1.start(); t2.start();
        t1.join(); t2.join();

//        EventProfiler.mark("    Threads done");

        HashMap<String, Integer> totalCounts = new HashMap<String, Integer>();

        // add leftCounter to totalCounts
        for (Map.Entry<String, Integer> e: leftCounter.wordCount.entrySet()){
            Integer currentCount = totalCounts.get(e.getKey());
            if (currentCount == null)
                totalCounts.put(e.getKey(), e.getValue());
            else
                totalCounts.put(e.getKey(), currentCount + e.getValue());
        }

        // oooops: code duplication here
        // add rightCounter to totalCounts
        for (Map.Entry<String, Integer> e: rightCounter.wordCount.entrySet()){
            Integer currentCount = totalCounts.get(e.getKey());
            if (currentCount == null)
                totalCounts.put(e.getKey(), e.getValue());
            else
                totalCounts.put(e.getKey(), currentCount + e.getValue());
        }

        profiler.log("2 Threads      " + totalCounts.toString());
    }
    public synchronized static void UpdateCounts(HashMap<String, Integer> totalCount, HashMap<String, Integer> partialCount) {
        for (Map.Entry<String, Integer> e: partialCount.entrySet()){
            Integer currentCount = totalCount.get(e.getKey());
            if (currentCount == null)
                totalCount.put(e.getKey(), e.getValue());
            else
                totalCount.put(e.getKey(), currentCount + e.getValue());
        }
    }
    public static void solveUsingNThreads(String[] text, int n) throws InterruptedException {
        EventProfiler profiler = new EventProfiler(true);
        profiler.start();

        HashMap<String, Integer> totalCounts = new HashMap<String, Integer>();

        ArrayList<Counter> counters = new ArrayList<Counter>();
        ArrayList<Thread> threads = new ArrayList<Thread>();

        // cut text in n parts, and create counters and threads
        int cutIndex = 0;
        int chunkSize = text.length / n;
        for (int i = 0; i < n; i++) {
            // System.out.println(cutIndex + " till " + (cutIndex + chunkSize));
            String[] textPart = Arrays.copyOfRange(text, cutIndex, (cutIndex + chunkSize));
            Counter counter = new Counter(textPart);

            counters.add(counter);
            threads.add(new Thread(counter));

            cutIndex = cutIndex + chunkSize;
        }

//        EventProfiler.mark("    Splitting text");

        for (Thread t: threads) {
            t.start();
        }

        for (Thread t: threads) {
            t.join();
        }

//        EventProfiler.mark("    Threads done");

        for (Counter counter: counters) {
            Words.UpdateCounts(totalCounts, counter.wordCount);
        }

        profiler.log(n + " Threads      " + totalCounts.toString());
    }
    public static void solveUsingNThreadsOnSharedData(String[] text, int n) throws InterruptedException {
        EventProfiler profiler = new EventProfiler(true);

        profiler.start();

        HashMap<String, Integer> totalCounts = new HashMap<String, Integer>();
        ArrayList<Counter> counters = new ArrayList<Counter>();
        ArrayList<Thread> threads = new ArrayList<Thread>();

        // cut text in n parts, and create counters and threads
        int cutIndex = 0;
        int chunkSize = text.length / n;
        for (int i = 0; i < n; i++) {
            // System.out.println(cutIndex + " till " + (cutIndex + chunkSize));
            Counter counter = new RangedCounter(text, cutIndex, (cutIndex + chunkSize), totalCounts);
            counters.add(counter);
            threads.add(new Thread(counter));

            cutIndex = cutIndex + chunkSize;
        }

//        EventProfiler.mark("    Splitting text");

        for (Thread t: threads) {
            t.start();
        }

        for (Thread t: threads) {
            t.join();
        }

//        EventProfiler.mark("    Threads done");

        profiler.log(n + " Threads      " + totalCounts.toString());
    }

    // use Xint VM setting to prevent JIT optimizations
    public static void main(String[] args) throws InterruptedException {
        // a producer/consumer solution with a BlockingQueue
        // solution: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html

        int capacity = 10;
        BlockingQueue<Page> queue = new ArrayBlockingQueue<Page>(capacity);

        ExecutorService executorService = Executors.newWorkStealingPool();

        // the producer and consumer
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);

        if (executorService.isTerminated())
            System.out.println(queue.size());



        // Producer
        // reads file and creates Pages that contain a certain amount of words


    }

}
