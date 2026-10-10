package practice.session_8;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();

        LocalDate baseDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1);

            int days = 0;
            if (type.equalsIgnoreCase("BOOK")) {
                days = 14;
            } else if (type.equalsIgnoreCase("DVD")) {
                days = 7;
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                days = 3;
            }

            LocalDate dueDate = baseDate.plusDays(days);
            System.out.println(title + ": " + dueDate);
        }
        scanner.close();
    }
}