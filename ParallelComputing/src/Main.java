import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static int[] array;
    private static int SIZE = 1000000;
    private static int MAX = 1000000;
    private static int amountofbuckets = 4;

    private static LinkedList[] bucket;
    private static Scanner sc;

    //dataset groter maken
    //problemen moet richting seconde
    //sort is dus bubblesort en dan parallelliseren

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Input yourself: ");
        String input = sc.next();
        if (input.equals("j")) {
            System.out.print("Size: "); SIZE = sc.nextInt();
            System.out.print("Amount of buckets: "); amountofbuckets = sc.nextInt();
        }

        //bucketsort
        System.out.println("Size: " +SIZE);
        System.out.println("Max: " +MAX);
        System.out.println("Amount of buckets: " +amountofbuckets);
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

    public static void bucketsort(int[] array) {
        double begin = System.nanoTime();

        //How many buckets and how big are they
        int bucketsize = (int) Math.ceil(MAX / amountofbuckets);

        // add buckets
        double addbuckets = System.nanoTime();
        System.out.print("Create buckets - ");
        bucket = new LinkedList[amountofbuckets];
        for (int i = 0; i < amountofbuckets; i++) {
            bucket[i] = new LinkedList<Integer>();
        }

        System.out.println((System.nanoTime() - addbuckets) / 1000000000);

        //loop array and put in buckets
        double arrayinbuckets = System.nanoTime();
        System.out.println("Put array in buckets - ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= amountofbuckets; j++){
                if (array[i]< bucketsize*j) {
                    bucket[j-1].add(array[i]);
                    break;
                }
            }
        }
        System.out.println((System.nanoTime() - arrayinbuckets) / 1000000000);

        //sort buckets
        System.out.print("parallel (p) or lineair (l): ");
        String pl = sc.next();
        if (pl.equals("p")){
            sortParalell();
        } else {
            sortLineair();
        }

        //print bucket size of buckets
        System.out.println("amount of buckets" + bucket.length);

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

    public static void sortParalell(){
        double sortbuckets = System.nanoTime();
        myThread[] threads = new myThread[amountofbuckets];
//        for (int i = 0; i< amountofbuckets; i++){
//            threads[i] = new myThread(bucket[i]);
//        }
//
//        for (int i = 0; i < amountofbuckets; i++){
//            threads[i].run();
//        }
//
//        try{
//            for (int i = 0; i< amountofbuckets; i++){
//                threads[i].join();
//            }
//        } catch (Exception e){
//            System.out.println(e);
//        }

        myThread thread1 = new myThread(bucket[0]);
        thread1.start();
        myThread thread2 = new myThread(bucket[1]);
        thread2.start();
        myThread thread3 = new myThread(bucket[2]);
        thread3.start();
        myThread thread4 = new myThread(bucket[3]);
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (Exception e){}
        System.out.println("Sorting buckets time Parallel: ");
        System.out.println((System.nanoTime() - sortbuckets) / 1000000000);
    }

    public static void sortLineair(){
        //sort every bucket
        double sortbuckets = System.nanoTime();
        System.out.println("Sort buckets - ");
        for (int i = 0; i < amountofbuckets; i++) {
            bubbleSort(bucket[i]);
        }
        System.out.println("Sorting buckets time Lineair: ");
        System.out.println((System.nanoTime() - sortbuckets) / 1000000000);
    }

    public static void bubbleSort(LinkedList list) {
        Object temp = list.get(0);
        for (int j = 0; j < list.size() -1; j++) {
            for (int i = 0; i < list.size() -j -1; i++) {
                if ((int)list.get(i) < (int)list.get(i+1)){
                    temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                }
            }
        }
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
