import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by konin on 31-3-2016.
 */


class TestReader implements Runnable {

    private long blockSize = 0;
    private long startIndex = 0;
    private String fileName = "";
    private RandomAccessFile randomAccessFile;

    public static long GetLength(String fileName) {
        try {
            RandomAccessFile aFile = new RandomAccessFile(fileName, "r");
            return  aFile.length();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public TestReader(String fileName, long blockSize, long startIndex) {
        this.fileName = fileName;
        this.blockSize = blockSize;
        this.startIndex = startIndex;

        try {
            randomAccessFile = new RandomAccessFile(fileName, "r");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

        EventProfiler profiler = new EventProfiler(true);
        profiler.start();

        int linenr = 0;

        try {

            randomAccessFile.seek(startIndex*8);

            String line = null;
            while (((line = randomAccessFile.readLine()) != null) && (linenr<blockSize)) {
                linenr++;
            }
            randomAccessFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        profiler.log("Text file read "+linenr);

    }
}

public class WordsTest {

    @Test
    public void testWriteTextToFile() throws Exception {
        String[] dictionary = Words.getSmallDictionary();
        String[] text = Words.generateText(dictionary, 1000000);
        Words.shuffle(text);

        String fileName = "d:\\temp\\medium.txt";
        Words.writeTextToFile(text, fileName);
    }


    @Test
    public void randomAccessTest() {
        EventProfiler profiler = new EventProfiler(true);
        profiler.start();

        try {
            String filename = "d:\\temp\\medium.txt";

            RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "r");
            long l = randomAccessFile.length();
            long lines = l/8;
            System.out.println("Lines in file:" + lines);

            randomAccessFile.seek(0);

            int linenr = 0;
            String line = null;
            while ((line = randomAccessFile.readLine()) != null) {
                linenr++;
            }
            randomAccessFile.close();
            profiler.log("Lines read:" + linenr);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Test
    public void testSerialReadTextFromFile() throws InterruptedException, IOException {

        String filename = "d:\\temp\\medium.txt";

        long l = TestReader.GetLength(filename);
        long lines = l/8;
        System.out.println("Lines in file:" + lines);

        long threadCount = 1;
        long blockSize = lines/threadCount;

        EventProfiler profiler = new EventProfiler(true);
        profiler.start();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new TestReader(filename, blockSize, 0));

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);

        if (executorService.isTerminated())
            profiler.log("Done ");
    }


    @Test
    public void testParallelReadTextFromFile() throws InterruptedException, IOException {

        String filename = "d:\\temp\\medium.txt";

        long l = TestReader.GetLength(filename);
        long lines = l/8;

        System.out.println("Lines in file:" + lines);

        long threadCount = 8;
        long block = lines/threadCount;
        System.out.println("Treads:" + threadCount);
        System.out.println("Block:" + block);


        EventProfiler profiler = new EventProfiler(true);
        profiler.start();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(new TestReader(filename, block, i*block));
        }

        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);

        if (executorService.isTerminated())
            profiler.log("Done ");
    }



    @Test
    public void testCountWordsFromFile() throws Exception {
        String[] text = null;

        EventProfiler profiler = new EventProfiler(true);
        profiler.start();
        String fileName = "d:\\temp\\tiny.txt";
        text = Words.readTextFromFile(fileName);

        Words.solveUsingSerialAlgorithm(text);
        profiler.log("Serial time ");

    }






    @Test
    public void testWriteRead() throws Exception {
        String[] dictionary = Words.getSmallDictionary();
        String[] originalText = Words.generateText(dictionary, 10);
        Words.shuffle(originalText);
        String fileName = "d:\\temp\\small.txt";
        Words.writeTextToFile(originalText, fileName);

        String[] textFromFile = Words.readTextFromFile(fileName);

        String fileCopyName = "data\\smallCopy.txt";
        Words.writeTextToFile(textFromFile, fileCopyName);
    }

    @Test
    public void testCountSmallFile() throws Exception {

        // prepping test case
        String[] dictionary = Words.getSmallDictionary();
        String[] text = Words.generateText(dictionary, 1000);
        Words.shuffle(text);
        String fileName = "d:\\temp\\small.txt";
        Words.writeTextToFile(text, fileName);

        EventProfiler profiler = new EventProfiler(true);
        // solving from memory
        profiler.start();
        Words.solveUsingNThreadsOnSharedData(text, 4);
        profiler.log("from memory");

        // solving from file
        profiler.start();
        text = Words.readTextFromFile(fileName);
        profiler.log("File read ");
        Words.solveUsingNThreadsOnSharedData(text, 4);
        profiler.log("4 threads done");

        // process while reading!
    }


    @Test
    public void testProblemScale() throws Exception {
        String[] dictionary = Words.getSmallDictionary();

        int problemSize = 5;
        for (int i = 1; i <= 6; i++){

            String[] text = Words.generateText(dictionary, problemSize);
            Words.shuffle(text);

//            Words.solveUsingSerialAlgorithm(text);
//            Words.SolveUsingTwoThreads(text);

            for (int n = 4; n <= 4; n++) {
//                Words.solveUsingNThreads(text, n);
                Words.solveUsingNThreadsOnSharedData(text, n); // using synchronised updates on totalCounts
//                System.out.println();
            }

            problemSize *=10;
        }

    }







}