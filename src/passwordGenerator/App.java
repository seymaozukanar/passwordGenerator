package passwordGenerator;

import java.util.Random;

public class App {
    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars){
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!'^+%&/()=?_";
        String allCharacters = "";

        // Construct a string with eligible characters.
        if(useLowercase){
            allCharacters += lowercaseLetters;
        }
        if(useUppercase){
            allCharacters += uppercaseLetters;
        }
        if(useNumbers){
            allCharacters += numbers;
        }
        if(useSpecialChars){
            allCharacters += specialChars;
        }

        // Generate a random password.
        for(int i=0; i<length; i++){
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            password.append(randomChar);
        }
        return password.toString();
    }

    public static boolean isValid(String password){
        // TODO: check whether the password includes all character types that user asks for
        return true;
    }

    public static void main(String[] args) {
        TextBasedUI ui = new TextBasedUI();

        boolean useLowercase = ui.useLowercase();
        boolean useUppercase = ui.useUppercase();
        boolean useNumbers = ui.useNumbers();
        boolean useSpecialChars = ui.useSpecialChars();
        boolean isPasswordValid;
        String password;

        do {
            password = generatePassword(15, useLowercase, useUppercase, useNumbers, useSpecialChars);
            isPasswordValid = isValid(password);
        } while (!isPasswordValid);

        System.out.println("Your password: " + password);
    }
}
