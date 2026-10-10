package practice.session_8;

import java.util.Scanner;

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        
        String[] types = new String[n];
        double[] amounts = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            amounts[i] = scanner.nextDouble();
        }
        scanner.close();

        for (int i = 0; i < n; i++) {
            double adjusted = amounts[i];
            if (types[i].equalsIgnoreCase("CARD")) {
                adjusted = amounts[i] * 1.02;
            } else if (types[i].equalsIgnoreCase("WALLET")) {
                adjusted = amounts[i] * 1.01;
            } else if (types[i].equalsIgnoreCase("BANKTRANSFER")) {
                adjusted = amounts[i];
            }
            total += adjusted;
            System.out.printf("%s: %.2f\n", types[i], adjusted);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}