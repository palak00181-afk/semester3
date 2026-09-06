package assignment.session_3;

public class DuplicatePlayerPickChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) return "No Duplicates Found";

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }
}