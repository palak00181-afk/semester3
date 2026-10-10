package assignment.session_8;

import java.util.Scanner;

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            double charge = 0;

            if (type.equalsIgnoreCase("BIKE")) {
                charge = hours * 10.0;
            } else if (type.equalsIgnoreCase("CAR")) {
                if (hours == 1) {
                    charge = 30.0;
                } else {
                    charge = 30.0 + (hours - 1) * 20.0;
                }
            } else if (type.equalsIgnoreCase("TRUCK")) {
                charge = Math.max(100.0, hours * 50.0);
            }

            grandTotal += charge;
            System.out.printf("%s: %.2f\n", type, charge);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}