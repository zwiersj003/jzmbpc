// from Paul Butcher

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


class Chopstick {
  private int id;
  public Chopstick(int id) { this.id = id; }
  public int getId() { return id; }
}

class Philosopher extends Thread {
  private ReentrantLock leftChopstick, rightChopstick;
  private Random random;
  private int thinkCount;

  public Philosopher(ReentrantLock leftChopstick, ReentrantLock rightChopstick) {
    this.leftChopstick = leftChopstick; this.rightChopstick = rightChopstick;
    random = new Random();
  }

  public void run() {
    try {
      while(true) {
        ++thinkCount;
        if (thinkCount % 10 == 0)
          System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
        Thread.sleep(random.nextInt(1000)); // Think for a while
        leftChopstick.lock();
        try {
          if (rightChopstick.tryLock(1000, TimeUnit.MILLISECONDS)) {
            // Got the right chopstick
            try {
              Thread.sleep(random.nextInt(1000)); // Eat for a while
            } finally { rightChopstick.unlock(); }
          } else {
            // Didn't get the right chopstick - give up and go back to thinking
            System.out.println("Philosopher " + this + " timed out");
          }
        } finally { leftChopstick.unlock(); }
      }
    } catch(InterruptedException e) {}
  }
}

public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[5];
    ReentrantLock[] chopsticks = new ReentrantLock[5];
    
    for (int i = 0; i < 5; ++i)
      chopsticks[i] = new ReentrantLock();
    for (int i = 0; i < 5; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
      philosophers[i].start();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
