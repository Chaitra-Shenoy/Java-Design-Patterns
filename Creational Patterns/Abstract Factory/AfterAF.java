import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface PaymentGatewayAF {
  void processPayment(double amount);
}

class RazorpayGatewayAF implements PaymentGatewayAF {
  public void processPayment(double amount) {
    System.out.println("Razorpay processed " + amount);
  }
}

class PaypalGatewayAF implements PaymentGatewayAF {
  public void processPayment(double amount) {
    System.out.println("PayPal processed " + amount);
  }
}

class StripeGatewayAF implements PaymentGatewayAF {
  public void processPayment(double amount) {
    System.out.println("Stripe processed " + amount);
  }
}

class PayUGatewayAF implements PaymentGatewayAF {
  public void processPayment(double amount) {
    System.out.println("PayU processed " + amount);
  }
}


interface InvoiceAF {
  void generateInvoice();
}

class GSTInvoiceAF implements InvoiceAF {
  public void generateInvoice() {
    System.out.println("GST Invoice generated!");
  }
}

class USInvoiceAF implements InvoiceAF {
  public void generateInvoice() {
    System.out.println("US Invoice generated!");
  }
}

interface RegionFactoryAF {
  PaymentGatewayAF getPaymentGateway(String paymentGateway);
  InvoiceAF getInvoice();
}

class IndiaFactoryAF implements RegionFactoryAF {

  private static final Map<String, Supplier<PaymentGatewayAF>> gatewayMap = new HashMap<>();

  static {
    gatewayMap.put("Razorpay", RazorpayGatewayAF::new);
    gatewayMap.put("PayPal", PaypalGatewayAF::new);
  }

  public PaymentGatewayAF getPaymentGateway(String paymentGateway) {
    Supplier<PaymentGatewayAF> supplier = gatewayMap.get(paymentGateway);

    if (supplier == null) {
      throw new IllegalArgumentException("Invalid Payment Gateway");
    }

    return supplier.get();
  }

  public InvoiceAF getInvoice() {
    return new GSTInvoiceAF();
  }
}

class USFactoryAF implements RegionFactoryAF {

  private static final Map<String, Supplier<PaymentGatewayAF>> gatewayMap = new HashMap<>();

  static {
    gatewayMap.put("Stripe", StripeGatewayAF::new);
    gatewayMap.put("PayU", PayUGatewayAF::new);
  }

  public PaymentGatewayAF getPaymentGateway(String paymentGateway) {
    Supplier<PaymentGatewayAF> supplier = gatewayMap.get(paymentGateway);

    if (supplier == null) {
      throw new IllegalArgumentException("Invalid Payment Gateway");
    }

    return supplier.get();
  }

  public InvoiceAF getInvoice() {
    return new USInvoiceAF();
  }
}

class CheckoutServiceAF {
  private PaymentGatewayAF pg;
  private InvoiceAF in;

  CheckoutServiceAF(RegionFactoryAF factory, String paymentGateway) {
    this.pg = factory.getPaymentGateway(paymentGateway);
    this.in = factory.getInvoice();
  }

  public void checkout() {
    pg.processPayment(1000);
    in.generateInvoice();
  }
}

public class AfterAF {
  public static void main(String args[]) {
    CheckoutServiceAF cs = new CheckoutServiceAF(new USFactoryAF(), "Stripe");
    cs.checkout();
  }
}