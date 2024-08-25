package deathValley;

public class Tank {
    private static final int RANGE_THRESHOLD = 200;

    public boolean enoughGas(int capacity, int gasDisplay, double consumption) {
        var currentCapacity = capacity * (gasDisplay / 100.0);

        var range = currentCapacity * consumption;

        return range >= RANGE_THRESHOLD;
    }

}
