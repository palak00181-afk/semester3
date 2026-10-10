package practice.session_8;

import java.util.Scanner;

public class TransitFareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            double fare = 0;

            if (type.equalsIgnoreCase("BUS")) {
                fare = Math.min(10.0, 2.0 + (distance * 0.10));
            } else if (type.equalsIgnoreCase("TRAIN")) {
                fare = 3.0 + (distance * 0.15);
            } else if (type.equalsIgnoreCase("METRO")) {
                double peakFactor = Double.parseDouble(parts[2]);
                fare = (1.50 + (distance * 0.20)) * peakFactor;
            }

            grandTotal += fare;
            System.out.printf("%s: %.2f\n", type, fare);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}