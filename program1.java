import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PrimeUtil {
    // Helper method to check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

// 1. Using Thread Class
class PrimeThread extends Thread {
    public void run() {
        System.out.print("Using Thread class (1-10): ");
        for (int i = 1; i <= 10; i++) {
            if (PrimeUtil.isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }
}

// 2. Using Runnable Interface
class PrimeRunnable implements Runnable {
    public void run() {
        System.out.print("Using Runnable interface (11-20): ");
        for (int i = 11; i <= 20; i++) {
            if (PrimeUtil.isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }
}

public class program1 {
    public static void main(String[] args) {
        System.out.println("=== Prime Number Generator using Multithreading ===\n");

        // Execute Thread
        PrimeThread t1 = new PrimeThread();
        t1.start();
        try { t1.join(); } catch (InterruptedException e) { e.printStackTrace(); }

        // Execute Runnable
        Thread t2 = new Thread(new PrimeRunnable());
        t2.start();
        try { t2.join(); } catch (InterruptedException e) { e.printStackTrace(); }

        // 3. Using Executor Framework
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            System.out.print("Using Executor Framework (21-30): ");
            for (int i = 21; i <= 30; i++) {
                if (PrimeUtil.isPrime(i)) System.out.print(i + " ");
            }
            System.out.println();
        });
        
        executor.shutdown();
        try {
            // Wait for executor to finish so output isn't cut off
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
