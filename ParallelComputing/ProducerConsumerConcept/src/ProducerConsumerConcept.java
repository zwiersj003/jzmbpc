import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by konin on 22-6-2016.
 */


class Producer implements Runnable {

    protected BlockingQueue<Integer> queue;
    protected int counter;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        this.counter = 0;
    }

    @Override
    public void run() {

        // keep running
        while (true) {

            try {
                queue.put(counter);
                System.out.println("Produced "+ counter);
                counter++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class SmartProducer extends Producer {
    private static int ID_NOT_USED = -99;
    private int id; // to identify a consumer
    private int totalProduction;

    public SmartProducer(int id, BlockingQueue<Integer> queue) {
        super(queue);
        this.id = id;
        this.totalProduction = 0;
    }


    @Override
    public void run() {

        Random rnd = new Random();

        // keep running
        while (true) {

            try {
                int value = id*1000+counter;

                queue.put(value);
                totalProduction ++;
                System.out.println("Producer "+ id + "("+ totalProduction + ") puts " + value);
                counter++;
                Thread.sleep(rnd.nextInt(2000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer implements Runnable {

    protected BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public Consumer(int id, BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter;

        Random rnd = new Random();

        // keep running
        while (true) {
            try {
                counter = queue.take();
                System.out.println("Consumer takes " + counter);
                // slow down the consumer
                Thread.sleep(rnd.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SmartConsumer extends Consumer {

    private static int ID_NOT_USED = -99;
    private int id; // to identify a consumer
    private int totalConsumption;

    public SmartConsumer(int id, BlockingQueue<Integer> queue) {
        super(queue);
        this.id = id;
        this.totalConsumption = 0;
    }

    @Override
    public void run() {
        int counter;

        Random rnd = new Random();

        // keep running
        while (true) {
            try {
                counter = queue.take();
                totalConsumption ++;
                System.out.println("Consumer "+ id + "("+ totalConsumption + ") takes " + counter);

                // slow down the consumer
                Thread.sleep(rnd.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// can be a filter
class Broker implements Runnable {
    protected BlockingQueue<Integer> input;
    protected BlockingQueue<Integer> output;

    public Broker(BlockingQueue<Integer> input, BlockingQueue<Integer> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int value = input.take();
                int newValue = value-50; // take out commission
                output.put(newValue);

                System.out.println(" Broker takes "+value + " and puts "+ newValue);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerConcept {

    public void singleProducerSingleSlowConsumer(int queueCapacity) throws InterruptedException {
        // a producer/consumer solution with a BlockingQueue
        // solution: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueCapacity);

        ExecutorService executorService = Executors.newWorkStealingPool();

        // the producer and consumer share a blocking queue
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // fire up producer and consumer
        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        if (executorService.isTerminated())
            System.out.println(queue.size());
    }


    public void singleProducerMultipleSlowSmartConsumers(int queueCapacity, int consumerCount) throws InterruptedException {
        // a producer/consumer solution with a BlockingQueue
        // solution: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html

        ExecutorService executorService = Executors.newCachedThreadPool();

        // the producer and consumer share a blocking queue
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueCapacity);

        Producer producer = new Producer(queue);
        executorService.submit(producer);

        for (int i = 1; i<= consumerCount; i++) {

            SmartConsumer smartConsumer = new SmartConsumer(i, queue);
            executorService.submit(smartConsumer);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        if (executorService.isTerminated())
            System.out.println(queue.size());

    }



    public void multipleSlowSmartProducersMultipleSlowSmartConsumers(int queueCapacity,
                                                         int producerCount,
                                                         int consumerCount) throws InterruptedException {
        // a producer/consumer solution with a BlockingQueue
        // solution: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/BlockingQueue.html

        ExecutorService executorService = Executors.newCachedThreadPool();

        // the producer and consumer share a blocking queue
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueCapacity);


        for (int i = 1; i<= producerCount; i++) {

            SmartProducer smartProducer = new SmartProducer(i, queue);
            executorService.submit(smartProducer);
        }

        for (int i = 1; i<= consumerCount; i++) {

            SmartConsumer smartConsumer = new SmartConsumer(i, queue);
            executorService.submit(smartConsumer);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        if (executorService.isTerminated())
            System.out.println(queue.size());

    }



    public void SingleProducerBrokerConsumerPipe(int producerMarketSize, int consumerMarketSize) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        BlockingQueue<Integer> producerMarket = new ArrayBlockingQueue<Integer>(producerMarketSize);
        BlockingQueue<Integer> consumerMarket = new ArrayBlockingQueue<Integer>(consumerMarketSize);

        // a producer produces on the producermarket
        Producer producer = new Producer(producerMarket);
        // a consumer consumes on the consumermarket
        Consumer consumer = new Consumer(consumerMarket);
        // a broker buys on the producermarket and sells on the consumermarket
        Broker broker = new Broker(producerMarket, consumerMarket);


        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.submit(broker);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }


    // use Xint VM setting to prevent JIT optimizations
    public static void main(String[] args) throws InterruptedException {

        ProducerConsumerConcept pc = new ProducerConsumerConcept();

        pc.singleProducerSingleSlowConsumer(20);
//        pc.singleProducerMultipleSlowSmartConsumers(20, 10);
//        pc.multipleSlowSmartProducersMultipleSlowSmartConsumers(20, 2, 5);

//        pc.SingleProducerBrokerConsumerPipe(5, 10);




    }



}
