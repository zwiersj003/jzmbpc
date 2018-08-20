import java.util.Arrays;
import java.util.LinkedList;

public class myThread extends Thread {

    int[] arrayThread;
    int bucketsize;
    LinkedList bucket;
    int amountofbuckets;

    public myThread(Object parameter) {
        bucket = (LinkedList) parameter;
    }

    public void run(){
//        System.out.println("MyThread running");
        double arrayinbuckets = System.nanoTime();
        bubbleSort(bucket);
        System.out.println((System.nanoTime() - arrayinbuckets) / 1000000000);
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
}
