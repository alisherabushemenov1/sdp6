package Strategy;

class PayPalPayment implements PaymentStrategy {
    private final String email;
    private final String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!authenticateUser()) {
            System.out.println("PayPal authentication failed");
            return false;
        }
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Account: " + email);
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "PayPal account: " + email;
    }

    private boolean authenticateUser() {
        return email != null && password != null && email.contains("@");
    }
}