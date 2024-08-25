package calculator;

import java.util.Locale;

public class Calculator {
    private static final String DIVISION_ERROR = "Division durch 0 nicht möglich!";
    private static final String OPERATOR_ERROR = "Sie müssen einen der vier Operatoren +,-,*,/ eingeben!";

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    public String calculate(double number1, double number2, char operator) {
        switch (operator) {
            case PLUS:
                var result = number1 + number2;
                return String.format(Locale.US,"%.1f + %.1f = %.1f", number1, number2, result);

            case MINUS:
                var result2 = number1 - number2;
                return String.format(Locale.US,"%.1f - %.1f = %.1f", number1, number2, result2);

            case MULTIPLY:
                var result3 = number1 * number2;
                return String.format(Locale.US,"%.1f x %.1f = %.2f", number1, number2, result3);

            case DIVIDE:
                if (number2 == 0)
                    return DIVISION_ERROR;

                var result4 = number1 / number2;
                return String.format(Locale.US,"%.1f : %.1f = %.1f", number1, number2, result4);

            default:
                return OPERATOR_ERROR;
        }
    }
}

