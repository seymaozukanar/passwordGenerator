package passwordGenerator;

import java.util.Scanner;

public class TextBasedUI implements UserInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getPasswordLength() {
        System.out.println("How many characters do you want your password to have?" +
                           "(Enter a number between 4 and 100.)");
        return scanner.nextInt();
    }

    @Override
    public boolean useLowercase() {
        System.out.println("Do you want to include lowercase characters? (y/n)");
        String input = scanner.nextLine();
        return (input.equalsIgnoreCase("y"));
    }

    @Override
    public boolean useUppercase() {
        System.out.println("Do you want to include uppercase characters? (y/n)");
        String input = scanner.nextLine();
        return (input.equalsIgnoreCase("y"));
    }

    @Override
    public boolean useNumbers() {
        System.out.println("Do you want to include numbers? (y/n)");
        String input = scanner.nextLine();
        return (input.equalsIgnoreCase("y"));
    }

    @Override
    public boolean useSpecialChars() {
        System.out.println("Do you want to include special characters? (y/n)");
        String input = scanner.nextLine();
        return (input.equalsIgnoreCase("y"));
    }
}
