package app_f;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    static final int END = -1;
    BlockingQueue<Integer> queue = null;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                int n = produce(i);
                queue.put(n);
            }
            queue.put(Producer.END);
        } catch (InterruptedException e) {
        }
    }

    int produce(int n) {
        sleepRandomly();
        System.out.println("Producer:" + getName() + "は " + n + " を生産完了");
        return n;
    }

    void sleepRandomly() {
        try {
            int n = (int)(Math.random() * 1000);
            Thread.sleep(n);
        } catch (InterruptedException e) {
        }
    }
}

class Consumer extends Thread {
    BlockingQueue<Integer> queue = null;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int n = queue.take();
                if (n == Producer.END) {
                    break;
                }
                consume(n);
            }
        } catch (InterruptedException e) {
        }
    }

    void consume(int n) {
        System.out.println("Consumer:" + getName() + "は " + n + " を消費中");
        sleepRandomly();
    }

    void sleepRandomly() {
        try {
            int n = (int)(Math.random() * 1000);
            Thread.sleep(n);
        } catch (InterruptedException e) {
        }
    }
}
