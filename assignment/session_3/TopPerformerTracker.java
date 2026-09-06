package assignment.session_3;

public class TopPerformerTracker {

    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) return "Invalid input";

        int min = scores[0];
        int max = scores[0];

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
            if (score > max) {
                max = score;
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }
}