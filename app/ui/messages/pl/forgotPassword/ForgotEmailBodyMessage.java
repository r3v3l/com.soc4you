package ui.messages.pl.forgotPassword;

/**
 * Created by adrian on 21.08.16.
 */
public class ForgotEmailBodyMessage {

    public static String message(String password){

        return "Twoje nowe hasło to: " +password+ ".<br></br>" + "Z poważaniem<br>Zespół soc4you.com";

    }

}
