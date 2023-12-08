import java.util.Random;
import java.util.HashSet;
import java.util.LinkedList;

public class PasswordGenerator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private static final int PASSWORD_LENGTH = 10; // Change this to your desired password length
    private static final int MAX_ATTEMPTS = 100; // Maximum attempts to generate a unique password

    private HashSet<String> previousPasswords = new HashSet<>();
    private LinkedList<String> lastFivePasswords = new LinkedList<>();

    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword();
        System.out.println("Generated Password: " + password);
    }

    public String generatePassword() {
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            String password = generateRandomPassword();
            if (isValidPassword(password) && isUniquePassword(password)) {
                addToPreviousPasswords(password);
                return password;
            }
        }
        return "Unable to generate a unique password.";
    }

    private String generateRandomPassword() {
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        password.append(ALPHABET.charAt(rand.nextInt(ALPHABET.length())));
        password.append(NUMBERS.charAt(rand.nextInt(NUMBERS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(rand.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 3; i < PASSWORD_LENGTH; i++) {
            char prevChar = password.charAt(i - 1);
            char prevPrevChar = password.charAt(i - 2);

            char nextChar;
            do {
                nextChar = ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
            } while (nextChar == prevChar || (i >= 2 && nextChar == prevPrevChar));

            password.append(nextChar);
        }

        return password.toString();
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[^A-Za-z\\d]).+$");
    }

    private boolean isUniquePassword(String password) {
        return !previousPasswords.contains(password) && !lastFivePasswords.contains(password);
    }

    private void addToPreviousPasswords(String password) {
        previousPasswords.add(password);
        lastFivePasswords.add(password);
        if (lastFivePasswords.size() > 5) {
            lastFivePasswords.poll();
        }
    }
}
