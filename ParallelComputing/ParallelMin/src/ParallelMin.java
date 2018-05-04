import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by koningrde on 24-3-2016.
 */


class EventProfiler {

    private long previousTimeStamp = -1;
    private boolean showLog = false;

    public EventProfiler(boolean showLog) {
        this.showLog = showLog;
    }

    public void logOff() {
        this.showLog = false;
    }

    public void logOn() {
        this.showLog = true;
    }

    public long start(){
        previousTimeStamp = System.nanoTime();
        return previousTimeStamp;
    };

    public long log(String label)
    {
        long thisTimeStamp = System.nanoTime();
        long duration = thisTimeStamp - previousTimeStamp;

        if (showLog)
            System.out.println(label + " takes "+ duration/1e6 + " ms");

        previousTimeStamp = thisTimeStamp;

        return previousTimeStamp;
    }
}

class Utils {

    // source: http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    // Implementing Fisher�Yates shuffle
    public static void shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void printArray(int[] anArray) {
        System.out.print("Array: ");
        for (int i=0; i< anArray.length; i++){
            System.out.print(anArray[i]+" ");
        }
        System.out.println();
    }


    public static int[] fillArray(int amount) {
        int[] result = new int[amount];
        for (int i=0; i<amount; i++){
            result[i] = i;
        }
        return result;
    }

    public static void addValue(int[] anArray, int value) {
        for (int i=0; i<anArray.length; i++){
            anArray[i] += value;
        }
    }
}

class MinimumInRangeRunner implements Runnable {

    private int[] anArray;
    private int fromIndex;
    private int tillIndex;


    public MinimumInRangeRunner(int[] anArray, int fromIndex, int tillIndex) {
        // store parameters for later use
        this.anArray = anArray;
        this.fromIndex = fromIndex;
        this.tillIndex = tillIndex;
    }

    @Override
    public void run() {
        int minimum = Integer.MAX_VALUE;
        int index = -1;

        minimum = Integer.MAX_VALUE;
        for (int i=fromIndex; i<tillIndex; i++) {
            if (anArray[i] < minimum) {
                index = i;
                minimum = anArray[index];
            }
        }
//        System.out.println("Local min " + localMin);
        ParallelMin.updateMin(minimum);
    }
}


class MinimumOnDeltaRunner implements Runnable {

    private int[] anArray;
    private int fromIndex;
    private int delta;

    public MinimumOnDeltaRunner(int[] anArray, int fromIndex, int delta) {
        this.fromIndex = fromIndex;
        this.delta = delta;
        this.anArray = anArray;
    }

    @Override
    public void run() {
        int minimum = Integer.MAX_VALUE;
        int index = -1;
        int tillIndex = anArray.length;

        for (int i=fromIndex; i<tillIndex; i+=delta) {
            if (anArray[i] < minimum) {
                index = i;
                minimum = anArray[index];
            }
        }
        // System.out.println("Local min with " + fromIndex + " and delta " + delta + " is " + minimum);
        ParallelMin.updateMin(minimum);
    }
}




public class ParallelMin {

    public static int globalMin;

    public synchronized  static void updateMin(int value)
    {
        if (value < globalMin)
            globalMin = value;
    }

    public static void main(String[] args) throws InterruptedException {

        // commandline parameter settings -Xms8096m -Xint

        EventProfiler profiler = new EventProfiler(true);

        profiler.start();

        int[] anArray = Utils.fillArray((int) 1e8);
//        int[] anArray = Utils.fillArray((int) 1e8);
        profiler.log("Filling array");

        Utils.addValue(anArray, -10);
        profiler.log("Adding value -10");

        Utils.shuffleArray(anArray);
        profiler.log("Shuffle array");

        profiler.start();
        ParallelMin.globalMin = Integer.MAX_VALUE;
        new MinimumInRangeRunner(anArray, 0, anArray.length).run();
        profiler.log("Finding minimum serial "+ ParallelMin.globalMin);

        List<Runnable> runners = new ArrayList<Runnable>();

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors " + processors);

        for (int cuts = 1; cuts <= processors; cuts++) {

            runners.clear();

            profiler.start();
            // problem decomposition, create tasks
            for (int i = 0; i < cuts; i++) {
                // bad memory locality
                runners.add(new MinimumOnDeltaRunner(anArray, i, cuts));
            }
            profiler.log("task creation ");

            globalMin = Integer.MAX_VALUE;
            // start threads
            ExecutorService executor = Executors.newCachedThreadPool();

            for (Runnable runnable: runners)
            {
                executor.submit(runnable);
            }

//            runners.forEach(executor::submit);

            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.DAYS))
                profiler.log(cuts + " threads done " + globalMin);
            System.out.println();
        }

    }

}
