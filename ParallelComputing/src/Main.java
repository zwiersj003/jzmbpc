import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    private static int[] array;
    private static int[] firstHalf;
    private static int[] secondHalf;
    private static int[] thirdHalf;
    private static int[] fourthHalf;
    private static final int SIZE = 1000;
    private static final int MAX = 1000000;
    private static final int amountofbuckets = 600;

    public static void main(String[] args) {
        //bucketsort
        System.out.println("Bucketsort");
        createRandomArray();
        bucketsort(array);
    }

    public static void createRandomArray(){
        array = new int[SIZE];
        for (int i = 0; i < SIZE; i++){
            int j = (int)(Math.random() * MAX);
            array[i] = j;
        }
    }

    public static void splitArray(){
        int beginOfParts = 0;
        int endOfParts = array.length/4;
        firstHalf = Arrays.copyOfRange(array, beginOfParts, endOfParts);
        beginOfParts += array.length/4;
        endOfParts += array.length/4;
        secondHalf= Arrays.copyOfRange(array, beginOfParts, endOfParts);
        beginOfParts += array.length/4;
        endOfParts += array.length/4;
        thirdHalf= Arrays.copyOfRange(array, beginOfParts, endOfParts);
        beginOfParts += array.length/4;
        endOfParts += array.length/4;
        fourthHalf= Arrays.copyOfRange(array, beginOfParts, endOfParts);
    }

    public static void bucketsort(int[] array) {
        double begin = System.nanoTime();

        //How many buckets and how big are they
        int bucketsize = (int) Math.ceil(MAX / amountofbuckets);

        // add buckets
        double addbuckets = System.nanoTime();
        System.out.print("Create buckets - ");
        LinkedList[] bucket = new LinkedList[amountofbuckets];
        for (int i = 0; i < amountofbuckets; i++) {
            bucket[i] = new LinkedList<Integer>();
        }

        System.out.println((System.nanoTime() - addbuckets) / 1000000000);

        //loop array and put in buckets
        double arrayinbuckets = System.nanoTime();
        System.out.print("Put array in buckets - ");

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 1; j <= amountofbuckets; j++){
//                if (array[i]< bucketsize*j) {
//                    bucket[j-1].add(array[i]);
//                    break;
//                }
//            }
//        }

        splitArray();

        myThread myThread1 = new myThread(firstHalf, bucketsize, bucket, amountofbuckets);
        myThread1.start();
        myThread myThread2 = new myThread(secondHalf, bucketsize, bucket, amountofbuckets);
        myThread2.start();
        myThread myThread3 = new myThread(thirdHalf, bucketsize, bucket, amountofbuckets);
        myThread3.start();
        myThread myThread4 = new myThread(fourthHalf, bucketsize, bucket, amountofbuckets);
        myThread4.start();
            try {
                myThread1.join();
                myThread2.join();
                myThread3.join();
                myThread4.join();
            } catch (Exception e) {
                System.out.println("Exception");
            }

        System.out.println((System.nanoTime() - arrayinbuckets) / 1000000000);

        //print bucket size of buckets
//        System.out.println("amount of buckets" + bucket.length);
//        for (int i = 0; i < amountofbuckets; i++){
//            System.out.println("bucketsize" + i +" = "+bucket[i].size());
//        }

        //sort every bucket
        double sortbuckets = System.nanoTime();
        System.out.println("Sort buckets - ");
        for (int i = 0; i < amountofbuckets; i++) {
//            System.out.print(i +" ");
            Collections.sort(bucket[i]);
        }
//        Collections.sort(bucket);
        System.out.println((System.nanoTime() - sortbuckets) / 1000000000);

        //buckets to array
        double bucketstoarray = System.nanoTime();
        System.out.print("Buckets to array - ");
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                array[index] = (Integer) bucket[i].get(j);
                index++;
            }
        }
        System.out.println((System.nanoTime() - bucketstoarray) / 1000000000);

        double eind = System.nanoTime();
        System.out.println();
        System.out.println("Tijd(sec):  " + (eind - begin) / 1000000000);
    }














    public static void pigeonholesort(int[] array)
    {
        for (Integer i : array){
            System.out.print(i + ", ");
        }
        double begin = System.nanoTime();

        // size of range of values in the list (ie, number of pigeonholes we need)
        int min = array[0], max = array[0];
        for (int x : array) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        final int size = max - min + 1;

        // our array of pigeonholes
        int[] holes = new int[size];

        // Populate the pigeonholes.
        for (int x : array)
            holes[x - min]++;

        // Put the elements back into the array in order.
        int i = 0;
        for (int count = 0; count < size; count++)
            while (holes[count]-- > 0)
                array[i++] = count + min;

        double eind = System.nanoTime();
        //Verschil in tijd geconverteerd naar seconden
        System.out.println();
        System.out.println("Tijd(sec):  " + (eind - begin) / 1000000000);
        for (Integer j : array){
            System.out.print(j + ", ");
        }
    }
}
