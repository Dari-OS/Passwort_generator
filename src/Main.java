import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger("Passi Geni");

    public static void main(final String[] args) {
        int length = 0;
        boolean specialChar = false;
        final StringBuilder password = new StringBuilder();
        final Scanner sc = new Scanner(System.in);
        LOGGER.info("Do you want special characters in your password(y/n): ");
        while (sc.hasNext()) {
            final String check = sc.next();
            if (check.contains("y") || check.contains("n")) {
                if (check.contains("y")) {
                    specialChar = true;
                }
                break;
            } else {
                LOGGER.warning("Please enter a valid answer! ");
                LOGGER.warning("Do you want special characters in your password(y/n): ");
            }
        }

        System.out.println("How long should your password be: ");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                length = sc.nextInt();
                break;
            } else {
                LOGGER.warning("Please type a valid int!");
                LOGGER.warning("How long should your password be: ");
            }

        }

        // We don't want to close it globally, JVM will handle this
        // sc.close();
        // Cache rand
        final Random rand = new Random();
        for (int i = 0; i < length; i++) {
            if (specialChar) {
                password.append(Symbol.symbolGetter(rand.nextInt(99)));
            } else {
                password.append(Symbol.symbolGetternoSpc(rand.nextInt(63)));
            }


        }
        LOGGER.info("Your password is: " + password);
    }
}
