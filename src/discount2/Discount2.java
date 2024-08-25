package discount2;

public class Discount2 {
    private static final int PORTO_THRESHOLD = 100;
    private static final int PORTO_COST = 2;

    private static final int PACKAGE_THRESHOLD = 250;
    private static final int PACKAGE_COST = 5;

    private static final int DISCOUNT_THRESHOLD = 500;
    private static final double DISCOUNT_PERCENT = 0.05d;

    public double calculatePorto(int amount) {
        if (amount <= PORTO_THRESHOLD)
            return PORTO_COST;

        return 0.00d;
    }

    public double calculatePackage(int amount) {
        if (amount <= PACKAGE_THRESHOLD)
            return PACKAGE_COST;

        return 0.00d;
    }

    public double calculateFinalPrice(int amount) {
        var total = amount + calculatePorto(amount) + calculatePackage(amount);
        if (total >= DISCOUNT_THRESHOLD)
            return total - (total * DISCOUNT_PERCENT);

        return total;
    }
}
