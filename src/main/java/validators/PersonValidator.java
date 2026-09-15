package validators;

public final class PersonValidator {

    private PersonValidator() {
    }

    public static boolean isValidAdultPerson(String input) {

        if (input == null || input.isBlank()) {
            return false;
        }

        String[] parts = input.trim().split("\\s+");

        if (parts.length != 3) {
            return false;
        }

        String name = parts[0];
        String ageText = parts[1];
        String years = parts[2];

        if (!"years".equals(years)) {
            return false;
        }

        if (name.length() <= 3) {
            return false;
        }

        try {

            int age = Integer.parseInt(ageText);

            return age >= 18;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
