package assignment.session_8;

import java.time.LocalDate;
import java.util.Scanner;

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();

            LocalDate startDate = LocalDate.parse(dateStr);
            int days = 0;

            if (type.equalsIgnoreCase("BASIC")) {
                days = 30;
            } else if (type.equalsIgnoreCase("STANDARD")) {
                days = 90;
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                days = 365;
            }

            LocalDate renewalDate = startDate.plusDays(days);
            System.out.println(name + ": " + renewalDate);
        }
        scanner.close();
    }
}