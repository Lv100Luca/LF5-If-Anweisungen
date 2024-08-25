package calculator;

import java.util.Scanner;

public class CalculatorUI {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.print("erste Zahl: ");
        var num1 = sc.nextDouble();

        System.out.print("zweite Zahl: ");
        var num2 = sc.nextDouble();

        System.out.print("Rechenoperation: ");
        char operator = sc.next().charAt(0);

        System.out.println(calc.calculate(num1, num2, operator));
    }

}
