package Strategy;

class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private double totalAmount;

    public ShoppingCart() {
        this.totalAmount = 0.0;
    }

    public void addItem(double price) {
        totalAmount += price;
        System.out.println("Item added. Total: $" + totalAmount);
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
        System.out.println("Payment method set: " + strategy.getPaymentDetails());
    }

    public boolean checkout() {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method");
            return false;
        }

        if (totalAmount <= 0) {
            System.out.println("Cart is empty");
            return false;
        }

        System.out.println("\n--- Processing Checkout ---");
        boolean success = paymentStrategy.processPayment(totalAmount);

        if (success) {
            System.out.println("Payment successful! Order confirmed.");
            totalAmount = 0.0;
        } else {
            System.out.println("Payment failed. Please try again.");
        }

        return success;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
