package controllers;

import helpers.EmailValidator;
import helpers.NewPasswordValidator;
import helpers.SendEmail;
import models.SignUpUserModel;
import org.jetbrains.annotations.NotNull;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import services.userModel.CheckUserEmailService;
import services.userModel.CheckUsernameService;
import services.userModel.CreateSignUpUserService;
import ui.messages.pl.signup.*;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian on 21.08.16.
 */
public class SignUpController extends Controller {

    public Result signUp() throws MessagingException {

        UserFingerprintController.saveData("New user signup.");
        Form<UserActionController.SignUp> signUpForm = Form.form(UserActionController.SignUp.class).bindFromRequest();
        if(signUpForm.hasErrors()){
            String errorMsg = getString(signUpForm);
            return signUpErrors(SignUpFormErrorsMessage.message() + errorMsg);
        }

        UserActionController.SignUp signUp = signUpForm.get();

        if((signUp.username.length() < 3) || (signUp.username.length() > 255)){
            return signUpWarning(InvalidUserNameLengthMessage.message());
        }

        if(CheckUsernameService.check(signUp.username) == true){
            return signUpWarning(UsernameExists.message());
        }

        if(!EmailValidator.isValidEmailAddress(signUp.email)){
            return signUpWarning(InvalidEmailFormatMessage.message());
        }

        if(CheckUserEmailService.check(signUp.email) == true){
            return signUpWarning(UserEmailExistsMessage.message());
        }

        String passwordMessage = NewPasswordValidator.validateNewPass(signUp.password, signUp.confirmPassword);
        if(passwordMessage != null){
            return signUpWarning(passwordMessage);
        }

        SignUpUserModel signUpUserModel = getSignUpUserModel(signUp);

        if(!CreateSignUpUserService.createUser(signUpUserModel)){
            return signUpErrors(CanNotCreateNewUserMessage.message());
        }

        sendEmail(signUpUserModel);

        return signUpSuccess(SuccessCreateAccountMessage.message());

    }

    @NotNull
    private String getString(Form<UserActionController.SignUp> signUpForm) {
        String errorMsg = "";
        Map<String, List<ValidationError>> errorsAll = signUpForm.errors();
        for (String field : errorsAll.keySet()) {
            errorMsg += field + " ";
            for (ValidationError error : errorsAll.get(field)) {
                errorMsg += error.message() + ", ";
            }
        }
        return errorMsg;
    }

    @NotNull
    private SignUpUserModel getSignUpUserModel(UserActionController.SignUp signUp) {
        SignUpUserModel signUpUserModel = new SignUpUserModel();
        signUpUserModel.email = signUp.email;
        signUpUserModel.username = signUp.username;
        signUpUserModel.password = signUp.password;
        return signUpUserModel;
    }

    private void sendEmail(SignUpUserModel signUpUserModel) throws MessagingException {

        HashMap<String, String> emailData = new HashMap<>();
        emailData.put("to", signUpUserModel.email);
        emailData.put("cc", "");
        emailData.put("title", SignUpEmailTitle.index());
        emailData.put("body", SignUpEmailMessage.message());
        emailData.put("smtpServer", "");
        emailData.put("user", "");
        emailData.put("password", "");

        SendEmail.generateAndSendEmail(emailData);

    }

    private Result signUpSuccess(String message){

        UserFingerprintController.saveData(message);
        flash("signUpFormSuccess", message);
        return redirect(routes.UserActionController.index());

    }

    private Result signUpErrors(String message){

        UserFingerprintController.saveData(message);
        flash("signUpFormError", message);
        return redirect(routes.UserActionController.index());

    }

    private Result signUpWarning(String message){

        UserFingerprintController.saveData(message);
        flash("signUpFormWarning", message);
        return redirect(routes.UserActionController.index());

    }

}
