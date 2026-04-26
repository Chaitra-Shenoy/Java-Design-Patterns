import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SMSThreadO implements Runnable {
  public void run() {
    try  {
      Thread.sleep(2000);
      System.out.println("SMS Sent");
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class EmailThreadO implements Runnable {
  public void run() {
    try  {
      Thread.sleep(2000);
      System.out.println("Email Sent");
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ETA implements Callable<String> {
  public String call() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("Calculating ETA!");
    return "ETA - 30 minutes from BLR";
  }
}
public class Other {
  public static void main(String args[]) {
    ExecutorService service = Executors.newFixedThreadPool(3);

    SMSThreadO sms = new SMSThreadO();
    EmailThreadO email = new EmailThreadO();

    ETA eta_ = new ETA();
    Future<String> eta = service.submit(eta_);

    service.submit(sms);
    service.submit(email);

    try {
      System.out.println(eta.get());
    }
    catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }

    service.shutdown();
  }  
}
