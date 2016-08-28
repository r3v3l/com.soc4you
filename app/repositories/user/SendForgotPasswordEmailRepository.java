package repositories.user;

import services.SendEmailSLL;

/**
 * Created by adrian on 28.08.16.
 */
public class SendForgotPasswordEmailRepository {

    public void send(String usernameEmail, String userPassword){

        String subject = "soc4you.com - przypomnienie hasła";
        String body = "<p>Twoje nowe hasło to: "+userPassword+"</p>" +
                "<p>Z poważaniem</p><p><strong>Zespół soc4you.</string></p>";
        String from = "kontakt@soc4you.com";
        String to = usernameEmail;
        String username = "";
        String password = "";
        SendEmailSLL sendEmailSLL = new SendEmailSLL();
        sendEmailSLL.send(username, password, from, to, subject, body);

    }

}
