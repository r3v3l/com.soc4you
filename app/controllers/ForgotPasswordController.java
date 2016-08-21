package controllers;

import helpers.EmailValidator;
import helpers.PasswordGenerator;
import helpers.SendEmail;
import models.UserModel;
import org.jetbrains.annotations.NotNull;
import play.data.Form;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.userRepository.SearchByEmailRepository;
import repositories.userRepository.SearchByUserNameRepository;
import services.userModel.CheckUserEmailService;
import services.userModel.CheckUsernameService;
import ui.messages.pl.forgotPassword.*;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian on 21.08.16.
 */
public class ForgotPasswordController extends Controller {

    public static class ForgotPassword {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String userData;

    }

    public Result index() throws MessagingException {

        Form<ForgotPassword> forgotPasswordForm = Form.form(ForgotPassword.class).bindFromRequest();
        if(forgotPasswordForm.hasErrors()){
            return forgotPasswordErrors(ForgotPasswordErrorMessage.message() + getString(forgotPasswordForm));
        }

        ForgotPassword forgotPassword = forgotPasswordForm.get();
        if(EmailValidator.isValidEmailAddress(forgotPassword.userData)){
            return forgotByEmail(forgotPassword.userData);
        }else {
            return forgotByUsername(forgotPassword.userData);
        }

    }

    private Result forgotByUsername(String username) throws MessagingException {
        if(CheckUsernameService.check(username) == true){
            UserModel userModel = SearchByUserNameRepository.searchByName(username);
            return generateAndSavePassword(userModel);
        }else {
            return forgotPasswordWarning(UsernameNotExistsMessage.message());
        }
    }

    private Result forgotByEmail(String email) throws MessagingException {

        if(CheckUserEmailService.check(email)){
            UserModel userModel = SearchByEmailRepository.searchByEmail(email);
            return generateAndSavePassword(userModel);
        }else {
            return forgotPasswordWarning(EmailNotExistsMessage.message());
        }

    }

    private Result generateAndSavePassword(UserModel userModel) throws MessagingException {
        String password = PasswordGenerator.genPass(25);
        updateUser(password, userModel);
        sendEmail(password, userModel);
        return forgotPasswordSuccess(ForgotPasswordErrorMessage.message());
    }

    private void sendEmail(String password, UserModel userModel) throws MessagingException {
        HashMap<String, String> emailData = new HashMap<>();
        emailData.put("to", userModel.email);
        emailData.put("cc", "");
        emailData.put("title", ForgotEmailTitleMessage.message());
        emailData.put("body", ForgotEmailBodyMessage.message(password));
        emailData.put("smtpServer", "");
        emailData.put("user", "");
        emailData.put("password", "");
        SendEmail.generateAndSendEmail(emailData);
    }

    private void updateUser(String password, UserModel userModel) {
        userModel.setPassword(password);
        userModel.updateDate = new Date();
        userModel.save();
    }

    @NotNull
    private String getString(Form<ForgotPassword> forgotPasswordForm) {
        String errorMsg = "";
        Map<String, List<ValidationError>> errorsAll = forgotPasswordForm.errors();
        for (String field : errorsAll.keySet()) {
            errorMsg += field + " ";
            for (ValidationError error : errorsAll.get(field)) {
                errorMsg += error.message() + ", ";
            }
        }
        return errorMsg;
    }

    private Result forgotPasswordSuccess(String message){

        UserFingerprintController.saveData(message);
        flash("forgotPasswordFormSuccess", message);
        return redirect(routes.UserActionController.index());

    }

    private Result forgotPasswordErrors(String message){

        UserFingerprintController.saveData(message);
        flash("forgotPasswordFormError", message);
        return redirect(routes.UserActionController.index());

    }

    private Result forgotPasswordWarning(String message){

        UserFingerprintController.saveData(message);
        flash("forgotPasswordFormWarning", message);
        return redirect(routes.UserActionController.index());

    }

}
