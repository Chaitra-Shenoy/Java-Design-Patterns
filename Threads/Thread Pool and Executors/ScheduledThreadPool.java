import java.util.concurrent.*;

public class ScheduledThreadPool {
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        // 1. Correct type + required pool size
        ScheduledExecutorService execService =
                Executors.newScheduledThreadPool(2);

        // 2. Scheduled task (delayed execution)
        execService.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + " sending email");
        }, 2, TimeUnit.SECONDS);

        // 3. Callable task with delay + Future
        Future<Integer> output = execService.schedule(() -> {
            System.out.println("Return value task running on " +
                    Thread.currentThread().getName());
            return 24;
        }, 1, TimeUnit.SECONDS);

        System.out.println("Intermediate Code!");

        System.out.println(output.get());

        execService.shutdown();
    }
}