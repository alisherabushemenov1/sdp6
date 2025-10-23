package Strategy;

interface PaymentStrategy {
    boolean processPayment(double amount);
    String getPaymentDetails();
}