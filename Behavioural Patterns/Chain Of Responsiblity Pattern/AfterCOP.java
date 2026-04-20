abstract class SupportHandler {
  protected SupportHandler nextHandler;

  public void setNextHandler(SupportHandler handler) {
    this.nextHandler = handler;
  }

  abstract public void handle(String type);
}

class GeneralHandler extends SupportHandler {
  public void handle(String type) {
    if ("general".equals(type))
      System.out.println("Handled by the customer support team");
    else if (nextHandler != null)
      nextHandler.handle(type);
  }
}

class BillingHandler extends SupportHandler {
  public void handle(String type) {
    if ("billing".equals(type))
      System.out.println("Handled by the billing team");
    else if (nextHandler != null)
      nextHandler.handle(type);
  }
}

class DeliveryHandler extends SupportHandler {
  public void handle(String type) {
    if ("delivery".equals(type))
      System.out.println("Handled by the delivery team");
    else if (nextHandler != null)
      nextHandler.handle(type);
    else
      System.out.println("No handler available");
  }
}

public class AfterCOP {
  public static void main(String args[]) {

    SupportHandler general = new GeneralHandler();
    SupportHandler billing = new BillingHandler();
    SupportHandler delivery = new DeliveryHandler();

    // Chain: general -> billing -> delivery
    general.setNextHandler(billing);
    billing.setNextHandler(delivery);

    general.handle("delivery");
    general.handle("billing");
    general.handle("unknown");
  }
}