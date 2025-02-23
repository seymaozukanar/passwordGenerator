package passwordGenerator;

import java.util.Random;

public class App {
    private final String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private final String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numbers = "0123456789";
    private final String specialChars = "!'^+%&/()=?_";

    private String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars){
        Random random = new Random();
        StringBuilder password = new StringBuilder();

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

    private boolean hasOverlap(String string1, String string2){
        for(char c: string1.toCharArray()){
            if(string2.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }

    private boolean isValid(String password, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSpecialChars){
        // Check whether the password includes all character types that user asks for.
        boolean isValid = true;

        if (useLowercase && !hasOverlap(password, lowercaseLetters)) {
            isValid = false;
        }
        if (useUppercase && !hasOverlap(password, uppercaseLetters)) {
            isValid = false;
        }
        if (useNumbers && !hasOverlap(password, numbers)) {
            isValid = false;
        }
        if (useSpecialChars && !hasOverlap(password, specialChars)) {
            isValid = false;
        }

        return isValid;
    }

    public static void main(String[] args) {
        TextBasedUI ui = new TextBasedUI();
        App app = new App();

        int passwordLength = ui.getPasswordLength();
        boolean useLowercase = ui.useLowercase();
        boolean useUppercase = ui.useUppercase();
        boolean useNumbers = ui.useNumbers();
        boolean useSpecialChars = ui.useSpecialChars();
        boolean isPasswordValid;
        String password;

        do {
            password = generatePassword(passwordLength, useLowercase, useUppercase, useNumbers, useSpecialChars);
            isPasswordValid = app.isValid(password, useLowercase, useUppercase, useNumbers, useSpecialChars);
        } while (!isPasswordValid);

        System.out.println("Your password: " + password);
    }
}
