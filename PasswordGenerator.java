import java.util.*;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUpper = scanner.nextBoolean();
        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLower = scanner.nextBoolean();
        System.out.print("Include numbers? (true/false): ");
        boolean includeDigits = scanner.nextBoolean();
        System.out.print("Include special characters? (true/false): ");
        boolean includePunctuation = scanner.nextBoolean();

        System.out.println("Generated Password: " + generatePassword(length, includeUpper, includeLower, includeDigits, includePunctuation));
    }

    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeDigits, boolean includePunctuation) {
        String charPool = "";
        if (includeUpper) {
            charPool += UPPER;
        }
        if (includeLower) {
            charPool += LOWER;
        }
        if (includeDigits) {
            charPool += DIGITS;
        }
        if (includePunctuation) {
            charPool += PUNCTUATION;
        }

        if (charPool.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be selected!");
        }

        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }
        return password.toString();
    }
}
