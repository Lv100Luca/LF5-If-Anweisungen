package deathValley;

import java.util.Scanner;

public class TankUI {
    public static void main(String[] args) {
        Tank tank = new Tank();
        var sc = new Scanner(System.in);



        System.out.print("Tank capacity: ");
        var capacity = sc.nextInt();

        System.out.print("Gas display: ");
        var gasDisplay = sc.nextInt();

        System.out.print("Consumption per mile: ");
        var consumption = sc.nextDouble();

        if (tank.enoughGas(capacity, gasDisplay, consumption))
            System.out.println("Enough gas!");
        else
            System.out.println("Fuel up!");
    }
}
