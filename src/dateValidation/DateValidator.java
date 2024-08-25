package dateValidation;

public class DateValidator {
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean validateDate(int day, int month, int year) {
        if (day < 1 || day > 31)
            return false;

        if (month < 1 || month > 12)
            return false;

        if (year < 1 || year > 9999)
            return false;

        var daysInMonth = getDaysInMonth(month, year);
        if (day > daysInMonth)
            return false;

        return true;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year))
            return 29;
        else
            return DAYS_IN_MONTH[month - 1];
    }
}
