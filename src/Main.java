import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length = 0;
        boolean specialChar = false;
        String password = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want special characters in your password(y/n): ");
        while (sc.hasNext()) {
            String check = sc.next();
            if (check.contains("y") || check.contains("n")) {

                if(check.contains("y")) {
                    specialChar = true;
                    break;
                } else {
                    specialChar = false;
                    break;
                }
            } else {
                System.out.println("Please enter a valid answer! ");
                System.out.println("Do you want special characters in your password(y/n): ");
                sc = new Scanner(System.in);
            }
        }

        sc = new Scanner(System.in);
        System.out.println("How long should your password be: ");

        while (sc.hasNext()) {

            if (sc.hasNextInt()) {

                length = sc.nextInt();
                break;
            }
            else {
                System.out.println("Please type a valid int!");
                System.out.print("How long should your password be: ");
                sc = new Scanner(System.in);

            }

        }

        sc.close();
        System.out.println("Your password is: ");
        for (int i = 0;i < length ;i++) {
            Random rand = new Random();
            if (specialChar) {
                password += Symbol.symbolGetter(rand.nextInt(99));
            } else {
                password += Symbol.symbolGetternoSpc(rand.nextInt(63));
            }


        }
        System.out.print(password);
        sc.close();
    }
}
