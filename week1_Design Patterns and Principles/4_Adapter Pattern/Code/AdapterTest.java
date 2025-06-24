interface PaymentProcessor {
    void processPayment();
}

class StripeGateway {
    public void stripePay() {
        System.out.println("Payment via Stripe");
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;
    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }
    public void processPayment() {
        stripe.stripePay();
    }
}

public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor payment = new StripeAdapter(new StripeGateway());
        payment.processPayment();
    }
}
