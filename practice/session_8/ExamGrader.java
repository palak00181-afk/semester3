package practice.session_8;

import java.util.Scanner;

public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String correct = parts[3];
            String student = parts[5];
            
            String remainder = parts[6].trim();
            double points = Double.parseDouble(remainder);
            double earned = 0;

            if (type.equalsIgnoreCase("MCQ") || type.equalsIgnoreCase("TF")) {
                if (student.equalsIgnoreCase(correct)) {
                    earned = points;
                }
            } else if (type.equalsIgnoreCase("ESSAY")) {
                String[] keywords = correct.toLowerCase().split(",");
                String ans = student.toLowerCase();
                int matchCount = 0;
                for (String kw : keywords) {
                    if (ans.contains(kw.trim())) {
                        matchCount++;
                    }
                }
                if (matchCount >= 2) {
                    earned = points;
                } else if (matchCount == 1) {
                    earned = points * 0.75;
                } else {
                    earned = 0;
                }
            }

            totalScore += earned;
            System.out.printf("%s: %.2f\n", type.toUpperCase(), earned);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }
}