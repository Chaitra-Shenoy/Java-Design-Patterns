import java.util.*;

class SMSThread extends Thread {
  public void run(){
    try  {
      Thread.sleep(2000);
      System.out.println("SMS Sent");
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class EmailThread extends Thread {
  public void run(){
    try  {
      Thread.sleep(2000);
      System.out.println("Email Sent");
    }
    catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}
public class ThreadClass {
  public static void main(String args[]) {
    SMSThread sms = new SMSThread();
    EmailThread email = new EmailThread();

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