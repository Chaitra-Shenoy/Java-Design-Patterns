class SMSThread implements Runnable {
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

class EmailThread implements Runnable {
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

public class RunnableInterface {
  public static void main(String args[]) {
    Thread sms = new Thread(new SMSThread());
    Thread email = new Thread(new EmailThread());

    sms.start();
    email.start();

    try {
      sms.join();
      email.join();
      System.out.println("All Tasks Completed!");
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
