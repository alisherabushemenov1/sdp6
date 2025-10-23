interface PaymentStrategy {
    boolean processPayment(double amount);
    String getPaymentDetails();
}