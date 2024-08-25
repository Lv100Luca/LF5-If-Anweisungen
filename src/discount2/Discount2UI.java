package discount2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Discount2UI {
    public static void main(String[] args) {
        Discount2 d = new Discount2();
        var sc = new Scanner(System.in);
        var decimalFormat = new DecimalFormat("0.00 EUR");

        System.out.print("Amount in EUR: ");
        var amount = sc.nextInt();

        System.out.println("Porto: " + decimalFormat.format(d.calculatePorto(amount)));
        System.out.println("Package: " + decimalFormat.format(d.calculatePackage(amount)));
        System.out.println("Final Price: " + decimalFormat.format(d.calculateFinalPrice(amount)));


    }
}
