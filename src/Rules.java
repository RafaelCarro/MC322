import java.util.regex.Pattern;

/*
Rules Class
Method Library that contains all methods for game rules and verifications.
 */
public class Rules {
    /**
     * Verifies if player CPF is a valid one.
     * @return bool*/
    public static boolean CPF_verify(String Num_CPF) {
        Num_CPF = Num_CPF.replaceAll("\\D", "");
        //Checks if CPF is 11 numbers long
        if (Num_CPF.length() != 11) {
            return false;
        }
        //Checks if all digits are equal
        int equals = 1;
        for (int i = 1; i < 11; i++) {
            if (Num_CPF.charAt(i) == Num_CPF.charAt(0)) {
                equals++;
            }
        }
        if (equals == 11) {
            return false;
        }
        //Checks for verification digits validation
        int ver1 = 0, ver2 = 0;
        //First verification number:
        for (int i = 8; i >= 0; i--) {
            ver1 += (Num_CPF.charAt(i) - '0')*(10-i);
        }
        ver1 = ver1 % 11;
        if (ver1 < 2) {
            ver1 = 0;
        }
        else {
            ver1 = 11 - ver1;
        }
        //Second verification number:
        for (int i = 8; i >= 0; i--) {
            ver2 += (Num_CPF.charAt(i) - '0')*(11-i);
        }
        ver2 += ver1 * 2;
        ver2 = ver2 % 11;
        if (ver2 < 2) {
            ver2 = 0;
        }
        else {
            ver2 = 11 - ver2;
        }
        //verification
        return ver1 == Num_CPF.charAt(9) - '0' && ver2 == Num_CPF.charAt(10) - '0';
    }

    //Email validation code by https://www.baeldung.com/java-email-validation-regex
    /**
     * Regex pattern matching*/
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    /**
     * Checks if Player email is a valid one, accepts Unicode characters.
     * @param emailAddress Email address to check if it's valid.
     * @return boolean
     * */
    public static boolean verify_email(String emailAddress) {
        return Rules.patternMatches(emailAddress, "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$");
    }
}
