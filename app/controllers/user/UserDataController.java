package controllers.user;

import controllers.common.CommonFingerprintingController;
import controllers.common.CommonJsonResponseController;
import controllers.common.CommonSecuredController;
import models.common.CommonUserModel;
import play.data.Form;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import repositories.common.commonUserModel.AuthenticateUserByUsernameRepository;
import repositories.common.commonUserModel.FindCommonUserModelByEmailRepository;
import repositories.common.commonUserModel.FindCommonUserModelByUsernameRepository;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by adrian on 28.08.16.
 */
@Security.Authenticated(CommonSecuredController.class)
public class UserDataController extends Controller {

    public CommonFingerprintingController commonFingerprintingController = new CommonFingerprintingController();

    public static class Email {

        @Constraints.Required
        @Constraints.MaxLength(255)
        @Constraints.Email
        public String email;

    }

    public static class Username {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String username;

    }

    public static class Password {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String oldPassword;

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String newPassword;

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String confirmPassword;

    }

    public Result changeEmail(){

        Form<Email> emailForm = Form.form(Email.class).bindFromRequest();
        if(emailForm.hasErrors()){
            commonFingerprintingController.save("User email form errors");
            return ok(emailForm.errorsAsJson());
        }

        Email email = emailForm.get();
        if(email.email.equals(session().get("email"))){
            commonFingerprintingController.save("New email " +email.email+ " and old email "
                    +session().get("email")+" are identical.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "emailsAreIdentical", "true"
                    )
            );
        }

        FindCommonUserModelByEmailRepository findCommonUserModelByEmailRepository =
                new FindCommonUserModelByEmailRepository();
        if(findCommonUserModelByEmailRepository.find(email.email) != null){
            commonFingerprintingController.save("Email " +email.email+ " exists. Please try again.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("emailExists", "true"));
        }

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                new FindCommonUserModelByUsernameRepository();
        CommonUserModel commonUserModel = findCommonUserModelByUsernameRepository.find(session().get("username"));
        if(commonUserModel == null){
            commonFingerprintingController.save("User "+commonUserModel.username+" not logged.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("userLogged", "false"));
        }

        commonUserModel.setEmail(email.email);
        commonUserModel.updateDate = new Date();
        commonUserModel.save();
        FindCommonUserModelByEmailRepository findByEmail =
                new FindCommonUserModelByEmailRepository();
        if(findByEmail.find(email.email) == null){
            commonFingerprintingController.save("Email not changed");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("changeEmail", "false"));
        }

        HashMap<String, CommonUserModel> userHashMap = new HashMap<>();
        userHashMap.put("user", commonUserModel);
        return ok(Json.toJson(userHashMap));

    }

    public Result changeUsername(){

        Form<Username> usernameForm = Form.form(Username.class).bindFromRequest();
        if(usernameForm.hasErrors()){
            commonFingerprintingController.save("Username form errors.");
            return ok(usernameForm.errorsAsJson());
        }

        Username username = usernameForm.get();
        if(username.username.equals(session().get("username"))){
            commonFingerprintingController.save(
                    "Old username " +session().get("username")+ "and new username "
                            +username.username+ " are identical."
            );
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("usernamesAreIdentical", "true"));
        }

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                new FindCommonUserModelByUsernameRepository();
        if(findCommonUserModelByUsernameRepository.find(username.username) != null){
            commonFingerprintingController.save("Username " +username.username+ " exists.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("usernameExists", "true"));
        }

        FindCommonUserModelByEmailRepository findCommonUserModelByEmailRepository =
                new FindCommonUserModelByEmailRepository();
        CommonUserModel commonUserModel = findCommonUserModelByEmailRepository.find(session().get("email"));
        if(commonUserModel == null){
            commonFingerprintingController.save("Session not exists.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("userLogged", "false"));
        }

        commonUserModel.username = username.username;
        commonUserModel.updateDate = new Date();
        commonUserModel.save();

        if(findCommonUserModelByUsernameRepository.find(username.username) == null){
            commonFingerprintingController.save("Username can not changed.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("usernameChanges", "false"));
        }

        HashMap<String, CommonUserModel> userHashMap = new HashMap<>();
        userHashMap.put("user", commonUserModel);
        return ok(Json.toJson(userHashMap));

    }

    public Result changePassword(){

        Form<Password> passwordForm = Form.form(Password.class).bindFromRequest();
        if(passwordForm.hasErrors()){
            commonFingerprintingController.save("Password form errors.");
            return ok(passwordForm.errorsAsJson());
        }

        Password password = passwordForm.get();
        if(!password.newPassword.equals(password.confirmPassword)){
            commonFingerprintingController.save("Passwords mismatch.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("passwordsMismatch", "true"));
        }

        AuthenticateUserByUsernameRepository authenticateUserByUsernameRepository =
                new AuthenticateUserByUsernameRepository();
        CommonUserModel commonUserModel = authenticateUserByUsernameRepository.findByUserName(
                session().get("username"), password.newPassword
        );
        if(commonUserModel == null){
            commonFingerprintingController.save("Invalid old password.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("oldPassword", "false"));
        }

        commonUserModel.setPassword(password.newPassword);
        commonUserModel.updateDate = new Date();
        commonUserModel.save();
        if(
                authenticateUserByUsernameRepository.findByUserName(
                        session().get("username"), password.newPassword
                ) == null
                ){
            commonFingerprintingController.save("Can not change password");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("changedPassword", "false"));
        }

        HashMap<String, CommonUserModel> userHashMap = new HashMap<>();
        userHashMap.put("user", commonUserModel);
        return ok(Json.toJson(userHashMap));

    }

}
