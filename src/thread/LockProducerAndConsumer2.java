package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: stone
 * Date: 2022/5/14 18:52
 */
public class LockProducerAndConsumer2 {
    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private final Lock lock = new ReentrantLock(false);
    private final Condition productCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                lock.lock();
                try {
                    while (queue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        try {
                            productCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    consumerCondition.signalAll();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("当前队列为空");
                        try {
                            consumerCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    productCondition.signalAll();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        LockProducerAndConsumer pc = new LockProducerAndConsumer();
        LockProducerAndConsumer.Producer producer = pc.new Producer();
        LockProducerAndConsumer.Producer producer2 = pc.new Producer();
        LockProducerAndConsumer.Consumer consumer = pc.new Consumer();
        LockProducerAndConsumer.Consumer consumer2 = pc.new Consumer();
        LockProducerAndConsumer.Consumer consumer3 = pc.new Consumer();
        LockProducerAndConsumer.Consumer consumer4 = pc.new Consumer();
        producer.start();
        producer2.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}
