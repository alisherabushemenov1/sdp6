package Strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add items to cart
        cart.addItem(29.99);
        cart.addItem(49.99);
        cart.addItem(15.50);

        System.out.println("\n=== Attempting Credit Card Payment ===");
        PaymentStrategy creditCard = new CreditCardPayment(
                "1234567890123456",
                "123",
                "12/25"
        );
        cart.setPaymentStrategy(creditCard);
        cart.checkout();

        // New purchase
        System.out.println("\n\n=== New Purchase ===");
        cart.addItem(99.99);
        cart.addItem(25.00);

        System.out.println("\n=== Attempting PayPal Payment ===");
        PaymentStrategy paypal = new PayPalPayment(
                "alisher.abushemenov@gmail.com",
                "securePassword123"
        );
        cart.setPaymentStrategy(paypal);
        cart.checkout();

        // Another purchase
        System.out.println("\n\n=== New Purchase ===");
        cart.addItem(199.99);

        System.out.println("\n=== Attempting Cryptocurrency Payment ===");
        PaymentStrategy crypto = new CryptoPayment(
                "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa",
                "Bitcoin"
        );
        cart.setPaymentStrategy(crypto);
        cart.checkout();
    }
}