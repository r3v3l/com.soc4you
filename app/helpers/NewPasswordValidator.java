package helpers;

import play.Logger;
import ui.messages.pl.signup.*;

/**
 * Created by adrian on 21.08.16.
 */
public class NewPasswordValidator {

    public static String validateNewPass(String pass1, String pass2){
        StringBuilder retVal = new StringBuilder();
        if (pass1 == null || pass2 == null) {
            Logger.info(PasswordsNullMessage.message());
            return PasswordsNullMessage.message();
        }

        if(pass1.length() < 1 || pass2.length() < 1 ){
            Logger.info(PasswordsNullMessage.message());
            return PasswordsNullMessage.message();
        }

        if (!pass1.equals(pass2)) {
            Logger.info(pass1 + " != " + pass2);
            return PasswordsMismatchMessage.message();
        }

        Logger.info(pass1 + " = " + pass2);

        pass1 = pass2;
        boolean hasUppercase = !pass1.equals(pass1.toLowerCase());
        boolean hasLowercase = !pass1.equals(pass1.toUpperCase());
        boolean hasNumber = pass1.matches(".*\\d.*");
        boolean noSpecialChar = pass1.matches("[a-zA-Z0-9 ]*");

        if (hasUppercase && hasLowercase && hasNumber && !noSpecialChar && pass1.length() < 12) {
            Logger.info("Password validates");
            return null;
        }

        if (pass1.length() < 12) {
            Logger.info(pass1 + " is length < 11");
            retVal.append(PasswordToShortMessage.message());
        }

        if (!hasUppercase) {
            Logger.info(pass1 + " <-- needs uppercase");
            retVal.append(PasswordNeedsUpperCaseMessage.message());
        }

        if (!hasLowercase) {
            Logger.info(pass1 + " <-- needs lowercase");
            retVal.append(PasswordNeedsLowercaseMessage.message());
        }

        if (!hasNumber) {
            Logger.info(pass1 + "<-- needs a number");
            retVal.append(PasswordNeedsNumberMessage.message());
        }

        if(noSpecialChar){
            Logger.info(pass1 + "<-- needs a specail character");
            retVal.append(PasswordNeedsSpecialCharsMessage.message());
        }

        if(retVal.length() == 0){
            Logger.info("Password validates");
            return null;
        }

        return retVal.toString();
    }

}
