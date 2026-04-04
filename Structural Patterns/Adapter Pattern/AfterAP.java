interface PaymentGatewayAP {
    void makeOrderPayment(String orderId, int amount);
}

class PayUPaymentGatewayAP implements PaymentGatewayAP {
    @Override
    public void makeOrderPayment(String orderId, int amount) {
        System.out.println("PayU Order ID - "+orderId + ", Paymemnt Amount = "+amount);
    }
}

class RazorPayAPI {
    public void makePayment(String orderId, int amount) {
        System.out.println("Razor Pay Order ID = "+orderId+", Amount = "+amount);
    }
}

class RazorPayAdapter implements PaymentGatewayAP { 
    private RazorPayAPI razorPayAPI;
    public RazorPayAdapter(RazorPayAPI razorPayAPI) {
        this.razorPayAPI = razorPayAPI;
    }
    @Override
    public void makeOrderPayment(String orderId, int amount) {
        razorPayAPI.makePayment(orderId, amount);
    }
}

class CheckoutServiceAP {
    private PaymentGatewayAP paymentGateway;
    public CheckoutServiceAP(PaymentGatewayAP paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(String orderId, int amount) {
        paymentGateway.makeOrderPayment(orderId, amount);
    }
}

public class AfterAP {
    public static void main(String[] args) {
      CheckoutServiceAP cs = new CheckoutServiceAP(new RazorPayAdapter(new RazorPayAPI()));
      cs.checkout("adsda1", 10000);

      CheckoutServiceAP cs1 = new CheckoutServiceAP(new PayUPaymentGatewayAP());
      cs1.checkout("adsda1", 10000);
    }
}