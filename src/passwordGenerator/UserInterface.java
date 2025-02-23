package passwordGenerator;

public interface UserInterface {
    int getPasswordLength();
    boolean useUppercase();
    boolean useLowercase();
    boolean useNumbers();
    boolean useSpecialChars();
}
