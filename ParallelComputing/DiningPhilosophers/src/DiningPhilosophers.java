// from Paul Butcher

import java.util.Random;

class Chopstick {
  private int id;
  public Chopstick(int id) { this.id = id; }
  public int getId() { return id; }
}

class Philosopher extends Thread {
    private Chopstick left, right;
    private Random random;
    private int thinkCount;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left; this.right = right;
        random = new Random();
    }

    public void run() {
        final int thinkTime = 100;
        final int eatTime = 100;

        try {
            while(true) {
                ++thinkCount;
                if (thinkCount % 10 == 0)
                    System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
                Thread.sleep(random.nextInt(thinkTime));     // Think for a while
                synchronized(left) {                    // Grab left chopstick
                    synchronized(right) {                 // Grab right chopstick
                        Thread.sleep(random.nextInt(eatTime)); // Eat for a while
                    }
                }
            }
        } catch(InterruptedException e) {}
    }
}

public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[5];
    Chopstick[] chopsticks = new Chopstick[5];
    
    for (int i = 0; i < 5; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < 5; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
      philosophers[i].start();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
