interface PaymentGateway {
  void processPayment(double amount);
}

class RazorpayGateway implements PaymentGateway {
  @Override
  public void processPayment(double amount) {
    System.out.println("Razorpay processed "+amount);
  }
}

class PaypalGateway implements PaymentGateway {
  @Override
  public void processPayment(double amount) {
    System.out.println("PayPal processed "+amount);
  }
}

interface Invoice {
  void generateInvoice();
}

class GSTInvoice implements Invoice {
  @Override
  public void generateInvoice() {
    System.out.println("GST Invoice generated!");
  }
}

class USInvoice implements Invoice {
  @Override 
  public void generateInvoice() {
    System.out.println("US Invoice generated!");
  }
}

class CheckoutService {
  private String paymentGateway;

  CheckoutService(String paymentGateway) {
    this.paymentGateway = paymentGateway;
  }

  public void checkout() {
    PaymentGateway pg;
    Invoice in;

    if(paymentGateway.equalsIgnoreCase("razorpay")) {
      pg = new RazorpayGateway();
      in = new GSTInvoice();
    }
    else if (paymentGateway.equalsIgnoreCase("paypal")) {
      pg = new PaypalGateway();
      in = new USInvoice();
    }
    else {
      System.out.println("Invalid Payment Gateway");
      return;
    }

    pg.processPayment(100);
    in.generateInvoice();
  }
}
public class BeforeAF {
  public static void main(String args[]) {
    CheckoutService cs = new CheckoutService("Razorpay");
    cs.checkout();
  }
}