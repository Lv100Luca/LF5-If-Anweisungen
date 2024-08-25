package discount;

import java.util.Scanner;

public class DiscountUI {
    public static void main(String[] args) {
        DiscountCalc discount = new DiscountCalc();
        var sc = new Scanner(System.in);

        System.out.print("Betrag: ");
        var amount = sc.nextInt();

        System.out.println(discount.calc(amount));
    }
}
