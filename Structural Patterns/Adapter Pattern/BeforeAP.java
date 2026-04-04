interface PaymentGateway {
    void makeOrderPayment(String orderId, int amount);
}

class PayUPaymentGateway implements PaymentGateway {
    @Override
    public void makeOrderPayment(String orderId, int amount) {
        System.out.println("PayU Order ID - "+orderId + ", Paymemnt Amount - "+amount);
    }
}

class RazorPayAPI_ {
    public void makePayment(String orderId, int amount) {
        System.out.println("Razor Pay Order ID = "+orderId+", Amount = "+amount);
    }
}

class CheckoutService {
    PaymentGateway paymentGateway;
    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(String orderId, int amount) {
        paymentGateway.makeOrderPayment(orderId, amount);
    }
}

public class BeforeAP {
    public static void main(String[] args) {
        CheckoutService cs = new CheckoutService(new PayUPaymentGateway());
        cs.checkout("adas1", 10000);
    }
}