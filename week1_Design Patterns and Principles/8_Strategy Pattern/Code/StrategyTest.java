interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid with Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid with PayPal");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void pay() {
        strategy.pay();
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment());
        context.pay();
        context.setStrategy(new PayPalPayment());
        context.pay();
    }
}
