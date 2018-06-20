import java.util.Arrays;
import java.util.LinkedList;

public class myThread extends Thread {

    int[] arrayThread;
    int bucketsize;
    LinkedList[] bucket;
    int amountofbuckets;

    public myThread(Object parameter1, Object parameter2, Object parameter3, Object parameter4) {
        arrayThread = (int[]) parameter1;
        bucketsize = (int) parameter2;
        bucket = (LinkedList[]) parameter3;
        amountofbuckets = (int) parameter4;
    }

    public void run(){
        System.out.println("Starting Thread");
        double arrayinbuckets = System.nanoTime();

        for (int i = 0; i < arrayThread.length; i++) {
            for (int j = 1; j <= amountofbuckets; j++){
                if (arrayThread[i]< bucketsize*j) {
                    bucket[j-1].add(arrayThread[i]);
                    break;
                }
            }
        }
//        System.out.println((System.nanoTime() - arrayinbuckets) / 1000000000);

//        for (Integer arr : arrayThread) {
//            System.out.println(arr);
//        }
    }
}
