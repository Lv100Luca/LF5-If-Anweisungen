package maexchen;

public class Maexchen {

    private static final int doubleMultiplier = 100;
    private static final int singleMultiplier = 10;

    private static final int maxPoints = 1000;

    private static final int diveLowerBound = 1;
    private static final int diveUpperBound = 6;

    public int calculatePoints(int throw1, int throw2) {
        if (throw1 < diveLowerBound || throw1 > diveUpperBound)
            return -1;

        if (throw2 < diveLowerBound || throw2 > diveUpperBound)
            return -1;

        if (throw1 == 1 && throw2 == 2)
            return maxPoints;

        if (throw1 == 2 && throw2 == 1)
            return maxPoints;

        if (throw1 == throw2)
            return throw1 * doubleMultiplier;

        if (throw1 > throw2)
            return (throw1 * singleMultiplier) + throw2;

        return throw2 * singleMultiplier + throw1;
    }
}
