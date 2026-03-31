class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        data = value;
        available = true;
        System.out.println("Producer produced: " + data);
        notifyAll();
    }

    public synchronized void consume() {
        while (!available) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println("Consumer consumed: " + data);
        available = false;
        notifyAll();
    }
}

class Producer extends Thread {
    SharedBuffer buffer;
    Producer(SharedBuffer b) { this.buffer = b; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try { Thread.sleep(500); } catch (Exception e) {}
        }
    }
}

class Consumer extends Thread {
    SharedBuffer buffer;
    Consumer(SharedBuffer b) { this.buffer = b; }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

public class Program2 {
    public static void main(String[] args) {
        System.out.println("=== Producer-Consumer Problem ===");
        SharedBuffer buffer = new SharedBuffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        
        p.start();
        c.start();
    }
}