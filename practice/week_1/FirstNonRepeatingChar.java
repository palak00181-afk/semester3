package practice.week_1;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String[] testStrings = {"swiss", "aabbcc"};

        for (String str : testStrings) {
            char result = findFirstNonRepeatingChar(str);
            if (result != '\0') {
                System.out.println("Input: \"" + str + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("Input: \"" + str + "\" -> No Non-Repeating Character Found");
            }
        }
    }
}