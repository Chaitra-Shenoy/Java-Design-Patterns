import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        ExecutorService execService = Executors.newFixedThreadPool(2);

        // Fire and forget task
        execService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " sending email");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Task with return value
        Future<Integer> output = execService.submit(() -> {
            System.out.println("Return value task running on " +
                    Thread.currentThread().getName());
            return 24;
        });

        System.out.println("Intermediate Code!");

        System.out.println(output.get());

        execService.shutdown();
    }
}