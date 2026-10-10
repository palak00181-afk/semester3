package assignment.session_8;

import java.util.Scanner;

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            double finalAmount = amount;

            if (type.equalsIgnoreCase("STUDENT")) {
                finalAmount = amount * 0.90;
            } else if (type.equalsIgnoreCase("STAFF")) {
                finalAmount = amount * 0.95;
            } else if (type.equalsIgnoreCase("GUEST")) {
                finalAmount = amount + 10.0;
            }

            total += finalAmount;
            System.out.printf("%s: %.2f\n", type, finalAmount);
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}