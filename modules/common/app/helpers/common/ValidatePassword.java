package helpers.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adrian on 27.08.16.
 */
public class ValidatePassword {

    public boolean isAcceptablePassword(String password) {
        if(password.length() < 12){
            return false;
        }
        Pattern p = Pattern.compile("[\\p{Alpha}]*[\\p{Punct}][\\p{Alpha}]*");
        Matcher m = p.matcher(password);
        return m.matches();
    }

}
