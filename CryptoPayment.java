class CryptoPayment implements PaymentStrategy {
    private final String walletAddress;
    private final String cryptoType;

    public CryptoPayment(String walletAddress, String cryptoType) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!validateWallet()) {
            System.out.println("Invalid wallet address");
            return false;
        }
        System.out.println("Processing " + cryptoType + " payment of $" + amount);
        System.out.println("Wallet: " + walletAddress);
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return cryptoType + " wallet: " +
                walletAddress.substring(0, 6) + "..." +
                walletAddress.substring(walletAddress.length() - 4);
    }

    private boolean validateWallet() {
        return walletAddress != null && walletAddress.length() >= 26;
    }
}
