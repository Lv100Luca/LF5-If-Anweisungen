package sort;

import java.util.Scanner;

public class SortUI {
    public static void main(String[] args) {
        Sort sort = new Sort();
        var sc = new Scanner(System.in);

        System.out.print("erste Größe: ");
        double a = sc.nextDouble();
        System.out.print("zweite Größe: ");
        double b = sc.nextDouble();
        System.out.print("dritte Größe: ");
        double c = sc.nextDouble();

        System.out.println(sort.sort(a, b, c));
    }
}
