package practice.session_1;

import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int origNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += (digit * digit * digit);
            number = number / 10;
        }

        if (sum == origNumber) {
            System.out.println(origNumber + " is an Armstrong number.");
        } else {
            System.out.println(origNumber + " is not an Armstrong number.");
        }

        scanner.close();
    }
}