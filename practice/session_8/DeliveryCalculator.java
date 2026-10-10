package practice.session_8;

import java.util.Scanner;

public class DeliveryCalculator {
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
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            double fee = 0;

            if (type.equalsIgnoreCase("STANDARD")) {
                fee = 5.0 + (weight * 0.50) + (distance * 0.10);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                fee = 15.0 + (weight * 1.00) + (distance * 0.20);
            } else if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customs = scanner.nextDouble();
                fee = 25.0 + (weight * 2.00) + (distance * 0.50) + customs;
            }

            grandTotal += fee;
            System.out.printf("%s: %.2f\n", type, fee);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}