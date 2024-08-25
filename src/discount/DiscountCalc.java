package discount;

public class DiscountCalc {
    private static final int DISCOUNT_PERCENT = 10;
    private static final int DISCOUNT_THRESHOLD_CENT = 1000; // 10 EUR

    public int calc(int amount) {
        if (amount <= DISCOUNT_THRESHOLD_CENT)
            return amount;
        else
            return amount - (amount * DISCOUNT_PERCENT / 100);
    }
}
