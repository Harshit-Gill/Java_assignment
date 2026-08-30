public class StringFundamentals {

    static boolean hasText(String value) {
        if (value == null) {
            return false;
        }

        if (value.length() == 0) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    static String normalizeCourseCode(String code) {
        if (code == null) {
            return null;
        }

        return code.trim().toUpperCase();
    }

    static int countOccurrences(String text, char target) {
        if (text == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }

    static int lengthOfLastWord(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }

        int i = text.length() - 1;

        while (i >= 0 && text.charAt(i) == ' ') {
            i--;
        }

        int length = 0;

        while (i >= 0 && text.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    static void reverseString(char[] characters) {
        if (characters == null || characters.length <= 1) {
            return;
        }

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }
    }
}
