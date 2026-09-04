package assignment.session_1;

public class SumNaturalNumbers {

    public static void sumOfNaturalNumbers(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }

    public static void main(String[] args) {
        sumOfNaturalNumbers(5);
    }
}