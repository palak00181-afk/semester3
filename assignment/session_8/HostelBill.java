package assignment.session_8;

import java.util.Scanner;

public class HostelBill {
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
            double bill = 0;

            if (type.equalsIgnoreCase("SINGLE")) {
                int units = scanner.nextInt();
                bill = units * 8.0;
            } else if (type.equalsIgnoreCase("SHARED")) {
                int units = scanner.nextInt();
                int occupants = scanner.nextInt();
                bill = (units * 6.0) / occupants;
            } else if (type.equalsIgnoreCase("AC")) {
                int units = scanner.nextInt();
                bill = (units * 10.0) + 200.0;
            }

            grandTotal += bill;
            System.out.printf("%s: %.2f\n", type, bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}