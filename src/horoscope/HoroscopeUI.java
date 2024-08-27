package horoscope;

import java.util.Scanner;

public class HoroscopeUI {
    public static void main(String[] args) {
        var horoscope = new HoroscopeGenerator();
        Scanner sc = new Scanner(System.in);

        System.out.print("Tag: ");
        var day = sc.nextInt();

        System.out.print("Monat: ");
        var month = sc.nextInt();

        System.out.println(horoscope.getHoroscope(day, month));
    }
}
