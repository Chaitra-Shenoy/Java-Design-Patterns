import java.util.concurrent.*;

public class StarvationSimulation {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Long running "high priority" tasks
        for (int i = 1; i <= 3; i++) {
            int id = i;

            executor.submit(() -> {
                System.out.println("LONG TASK " + id + " started");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("LONG TASK " + id + " finished");
            });
        }

        // Small tasks that get delayed
        for (int i = 1; i <= 10; i++) {
            int id = i;

            executor.submit(() -> {
                System.out.println("Short task " + id);
            });
        }

        executor.shutdown();
    }
}