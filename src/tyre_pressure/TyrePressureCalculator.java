package tyre_pressure;

public class TyrePressureCalculator {
    private static final int TYRE_PRESSURE_ALLOWED_DIFF = 3;

    private static final int TYRE_PRESSURE_MAX = 45;
    private static final int TYRE_PRESSURE_MIN = 35;

    public boolean calc(int frontRight, int frontLeft, int behindRight, int behindLeft) {
        // check front tyres
        var frontTyreDiff = Math.abs(frontRight - frontLeft);
        if (frontTyreDiff > TYRE_PRESSURE_ALLOWED_DIFF)
            return true;

        // check rear tyres
        var rearTyreDiff = Math.abs(behindRight - behindLeft);
        if (rearTyreDiff > TYRE_PRESSURE_ALLOWED_DIFF)
            return true;

        int[] tyres = {frontRight, frontLeft, behindRight, behindLeft};
        for (int tyre : tyres) {
            if (!checkTyre(tyre))
                return true;
        }
        return false;
    }

    public boolean checkTyre(int pressure) {
        return pressure >= TYRE_PRESSURE_MIN && pressure <= TYRE_PRESSURE_MAX;
    }
}
