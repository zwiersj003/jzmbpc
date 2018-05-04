import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.fail;

/**
 * Created by konin on 17-6-2016.
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


// keeps track of all threads spawned in a logical computation
class JobTracker {
    private static ExecutorService executor;
    private static AtomicInteger threadsInProgress;

    public JobTracker() {
        executor = Executors.newCachedThreadPool();
//        executor = Executors.newWorkStealingPool();
    }

    protected void start(){
        threadsInProgress = new AtomicInteger(0);
    }

    protected int spawn(Runnable r) {
        executor.submit(r);
        int running = threadsInProgress.incrementAndGet();
//        System.out.println("Spawned, now running "+ running);
        return running;
    }

    protected int done(){
        int running = threadsInProgress.decrementAndGet();
//        System.out.println("Done, now running "+ running);
        return running;
    }

    protected boolean running() {
        int running = threadsInProgress.get();

        return running>0;
    }

    protected void await(){
        while (running())
        {
            // stay idle while waiting for threads to finish
        }
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
            // Simple swap -> RKO: use swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
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

    public static boolean isFilledArray(int[] array)
    {
        for (int i=0; i < array.length; i++){
            if (array[i] != i)
                return false;
        }
        return true;
    }

    public static void addValue(int[] anArray, int value) {
        for (int i=0; i<anArray.length; i++){
            anArray[i] += value;
        }
    }
}

class Splitter implements Runnable {

    private int[] anArray;
    private int low;
    private int high;
    public int pivotIndex;


    public Splitter(int[] anArray) {
        this.anArray = anArray;
        this.low = 0;
        this.high = anArray.length-1;
    }

    public Splitter(int[] anArray, int low, int high, int pivot) {
        this.anArray = anArray;
        this.low = low;
        this.high = high;
    }

    public String toString() {
        return ""+pivotIndex;
    }

    public void pivotSplit(int pivot)
    {
//        System.out.println("Splitting on "+pivot);
        this.pivotIndex = pivotPartition(anArray, low, high, pivot);
    }

    public int pivotPartition(int[] list, int first, int last, int pivot) {

        int i = first; // Index for forward search
        int j = last ; // Index for backward search

        while (i < j) {
            // Search forward from left
            while (i <= j && list[i] <= pivot)
                i++;

            // Search backward from right
            while (i <= j && list[j] > pivot)
                j--;

            // Swap two elements in the list
            if (i < j) {
                Utils.swap(list, i, j);
//                System.out.print("["+i + "," + j+"]");
//                Utils.printArray(list);
            }
        }

//        System.out.print("["+i + "," + j+"]");
        // list [low..j] contains elements <= pivot
        // list [j+1..high] contains element >= pivot
        return j;
    }

    @Override
    public void run() {
    }
}

class Sorter implements Runnable {

    private int[] anArray;
    private int fromIndex;
    private int tillIndex;

    private static JobTracker tracker = new JobTracker();
    public static int spawnSize = 100;

    public Sorter(int[] anArray) {
        this.anArray = anArray;
        this.fromIndex = 0;
        if (anArray != null)
            this.tillIndex = anArray.length-1;
        else
            this.tillIndex = -1;

    }

    private Sorter(int[] anArray, int fromIndex, int tillIndex)
    {
        this.anArray = anArray;
        this.fromIndex = fromIndex;
        this.tillIndex = tillIndex;
    }

    public int size() {
        return  (tillIndex-fromIndex+1);
    }


    @Override
    public void run() {
//        vogellaParallelQuickSort(anArray, fromIndex, tillIndex);
        liangParallelQuickSort(anArray, fromIndex, tillIndex);
        tracker.done();
    }

    public void serialQuickSort()
    {
//       vogellaQuicksort(fromIndex, tillIndex);
        liangQuickSort(anArray, fromIndex, tillIndex);
    }

    public void parallelQuickSort() {
        tracker.start();
        tracker.spawn(this);
        tracker.await();
    }


    // http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
    private void vogellaQuicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = anArray[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (anArray[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (anArray[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                Utils.swap(anArray, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            vogellaQuicksort(low, j);
        if (i < high)
            vogellaQuicksort(i, high);
    }
    private void vogellaParallelQuickSort(int[] list, int low, int high) {

        int i = low, j = high;
        int pivot = list[low + (high - low) / 2];

        while (i <= j) {
            while (list[i] < pivot) {
                i++;
            }

            while (list[j] > pivot) {
                j--;
            }

            if (i <= j) {
                Utils.swap(list, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            Sorter lows = new Sorter(list, low, j);
            tracker.spawn(lows);
        }

        if (i < high) {
            Sorter his = new Sorter(list, i, high);
            tracker.spawn(his);
        }

    }

    // http://www.cs.armstrong.edu/liang/intro9e/html/QuickSort.html
    private void liangQuickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            liangQuickSort(list, first, pivotIndex - 1);
            liangQuickSort(list, pivotIndex + 1, last);
        }
    }
    private void liangParallelQuickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            Sorter lows = new Sorter(list, first, pivotIndex-1);
            Sorter his = new Sorter(list, pivotIndex+1, last);

            if (lows.size()>spawnSize)
                tracker.spawn(lows);
            else
                lows.serialQuickSort();


            if (his.size()>spawnSize)
                tracker.spawn(his);
            else
                his.serialQuickSort();
        }
    }

    /** Partition the array list[first..last] */
    private int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
}



public class QuickSort  {


    public static void main(String[] args) throws InterruptedException {

        // commandline parameter settings -Xms8096m -Xint

        EventProfiler profiler = new EventProfiler(true);
        profiler.start();

        int[] originalArray = Utils.fillArray(1000000);
        profiler.log("Filling array");

        Utils.shuffleArray(originalArray);
        profiler.log("Shuffle array");

        int[] arrayForSerialSort = Arrays.copyOfRange(originalArray, 0, originalArray.length);
        Sorter serialSorter = new Sorter(arrayForSerialSort);

        profiler.start();
        serialSorter.serialQuickSort();

        if (Utils.isFilledArray(arrayForSerialSort))
            profiler.log("Serial QuickSort Done");
        else
            profiler.log("Serial QuickSort failed");


        arrayForSerialSort = Arrays.copyOfRange(originalArray, 0, originalArray.length);
        profiler.start();
        Arrays.sort(arrayForSerialSort);
        if (Utils.isFilledArray(arrayForSerialSort))
            profiler.log("Java Sort Done");
        else
            profiler.log("Java Sort failed");


        int[] arrayForJavaParallelSort = Arrays.copyOfRange(originalArray, 0, originalArray.length);
        profiler.start();
        Arrays.parallelSort(arrayForJavaParallelSort);
        if (Utils.isFilledArray(arrayForJavaParallelSort))
            profiler.log("Java Parallel Sort Done");
        else
            profiler.log("Java Parallel Sort failed");


        int[] arrayForOwnParallelSort = Arrays.copyOfRange(originalArray, 0, originalArray.length);
        Sorter parallelSorter = new Sorter(arrayForOwnParallelSort);
        profiler.start();
        parallelSorter.spawnSize = 1;
        parallelSorter.parallelQuickSort();

        if (Utils.isFilledArray(arrayForOwnParallelSort))
            profiler.log("Parallel Sort Done, spawn size "+parallelSorter.spawnSize);
        else
            profiler.log("Parallel Sort Failed, spawn size "+parallelSorter.spawnSize);


        arrayForOwnParallelSort = Arrays.copyOfRange(originalArray, 0, originalArray.length);
        parallelSorter = new Sorter(arrayForOwnParallelSort);
        profiler.start();
        parallelSorter.spawnSize = 1000;
        parallelSorter.parallelQuickSort();

        if (Utils.isFilledArray(arrayForOwnParallelSort))
            profiler.log("Parallel Sort Done, spawn size "+parallelSorter.spawnSize);
        else
            profiler.log("Parallel Sort Failed, spawn size "+parallelSorter.spawnSize);



        arrayForOwnParallelSort = Arrays.copyOfRange(originalArray, 0, originalArray.length);
        parallelSorter = new Sorter(arrayForOwnParallelSort);
        profiler.start();
        parallelSorter.spawnSize = 10000;
        parallelSorter.parallelQuickSort();

        if (Utils.isFilledArray(arrayForOwnParallelSort))
            profiler.log("Parallel Sort Done, spawn size "+parallelSorter.spawnSize);
        else
            profiler.log("Parallel Sort Failed, spawn size "+parallelSorter.spawnSize);




    }
}
