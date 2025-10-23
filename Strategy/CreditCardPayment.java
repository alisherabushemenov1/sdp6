package Strategy;

class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    public CreditCardPayment(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!validateCard()) {
            System.out.println("Invalid card details");
            return false;
        }
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card: " + cardNumber);
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4);
    }

    private boolean validateCard() {
        return cardNumber != null && cvv != null && expiryDate != null;
    }

    private String maskCardNumber(String number) {
        if (number.length() < 4) return number;
        return "**** **** **** " + number.substring(number.length() - 4);
    }
}