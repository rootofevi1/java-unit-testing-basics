package utils;

public final class PalindromeChecker {

    private PalindromeChecker() {
    }

    public static boolean isPalindrome(String value) {

        if (value == null) {
            return false;
        }

        String normalized = value.trim()
                .replaceAll("\\s+", "")
                .toLowerCase();

        return normalized.contentEquals(
                new StringBuilder(normalized).reverse()
        );
    }
}
