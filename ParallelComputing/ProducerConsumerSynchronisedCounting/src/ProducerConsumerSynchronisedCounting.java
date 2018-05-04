import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by konin on 22-6-2016.
 */





// a count job is a list of words to be counted
class CountJob {
    public ArrayList<String> list; // public for now

    public CountJob() {
        this.list = new ArrayList<String>();
    }

    public void count(HashMap<String, Integer> counts) {

        for (String word: list) {

            Integer currentCount = counts.get(word);
            if (currentCount == null)
                counts.put(word, 1);
            else
                counts.put(word, currentCount + 1);

        }

        System.out.println(counts.toString());
    }
}

class CountJobProducer implements Runnable {

    private int jobsProduced;
    private String fileName;
    private BlockingQueue<CountJob> queue;

    public CountJobProducer(String fileName, BlockingQueue<CountJob> queue) {

        this.queue = queue;
        this.fileName = fileName;
        this.jobsProduced = 0; // performance statistics
    }

    @Override
    public void run() {
        // read the file and put count jobs in the queue


        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));

            CountJob cj = new CountJob();

            String line = null;
            while ((line = reader.readLine()) != null) {
                cj.list.add(line);

                // 100 words per count job
                if (cj.list.size() == 100) {
                    try {
                        queue.put(cj);
                        jobsProduced++;
                        System.out.println("Produced job "+jobsProduced);
                        cj = new CountJob();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            // flush the remaining job if it contains any words
            if (cj.list.size()>0) {
                try {
                    queue.put(cj);
                    jobsProduced++;
                    System.out.println("Produced job "+jobsProduced);
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

class CountJobConsumer implements Runnable {

    private int id; // to identify a consumer
    private BlockingQueue<CountJob> queue;
    private HashMap<String, Integer> counts;

    // performance statistics
    private int jobsProcessed;

    public CountJobConsumer(BlockingQueue<CountJob> queue, int id, HashMap<String, Integer> counts) {
        this.queue = queue;
        this.id = id;
        this.counts = counts;
        this.jobsProcessed = 0;
    }

    @Override
    public void run() {
        // keep running
        while (true) {
            try {
                CountJob job = queue.take();
                jobsProcessed++;

                // delegate the counting job to the job itself hahahaha
                job.count(counts);

                System.out.println("Consumer " + id + " processed "+jobsProcessed);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



public class ProducerConsumerSynchronisedCounting {



    public void SingleProducerSingleConsumers(int queueCapacity) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        // stores the counts of all words <word, #> in a hashmap
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();

        BlockingQueue<CountJob> queue = new ArrayBlockingQueue<CountJob>(queueCapacity );
        String fileName = "d:\\temp\\tiny.txt";

        CountJobProducer producer = new CountJobProducer(fileName, queue);
        CountJobConsumer consumer1 = new CountJobConsumer(queue, 1, wordCounts);
//        CountJobConsumer consumer2 = new CountJobConsumer(queue, 2, wordCounts);
//        CountJobConsumer consumer3 = new CountJobConsumer(queue, 3, wordCounts);

        executorService.submit(producer);
        executorService.submit(consumer1);
//        executorService.submit(consumer2);
//        executorService.submit(consumer3);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }


    // use Xint VM setting to prevent JIT optimizations
    public static void main(String[] args) throws InterruptedException {

        ProducerConsumerSynchronisedCounting pc = new ProducerConsumerSynchronisedCounting();

        pc.SingleProducerSingleConsumers(10000);
    }


}
