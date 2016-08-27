package controllers.user;

import controllers.common.CommonFingerprintingController;
import controllers.common.CommonJsonResponseController;
import helpers.common.ValidatePassword;
import play.data.Form;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.common.commonUserModel.FindCommonUserModelByEmailRepository;
import repositories.common.commonUserModel.FindCommonUserModelByUsernameRepository;
import services.common.userModelCommon.CreateCommonUserModelService;

import java.util.HashMap;

/**
 * Created by adrian on 27.08.16.
 */
public class UserSignUpController extends Controller {

    public CommonFingerprintingController commonFingerprintingController = new CommonFingerprintingController();
    public CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();

    public static class SignUp {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String username;

        @Constraints.Required
        @Constraints.MaxLength(255)
        @Constraints.Email
        public String email;

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String password;

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String confirmPassword;

    }

    public Result index(){

        HashMap<String, String> signUpErrors = new HashMap<>();

        Form<SignUp> signUpForm = Form.form(SignUp.class).bindFromRequest();
        if(signUpForm.hasErrors()){
            commonFingerprintingController.save("Signup form errors.");
            return ok(signUpForm.errorsAsJson());
        }

        SignUp signUp = signUpForm.get();

        if(!checkUsername(signUp.username)){
            commonFingerprintingController.save("User " +signUp.username+ " exists. Please try again.");
            signUpErrors.put("usernameExists", "User " +signUp.username+ " exists. Please try again.");

        }

        if(!checkEmail(signUp.email)){
            commonFingerprintingController.save("Email " + signUp.email+ " exists. Please try again.");
            signUpErrors.put("emailExists", "Email " + signUp.email+ " exists. Please try again.");
        }

        if(!checkPassword(signUp.password)){
            commonFingerprintingController.save("Password isn't strong.");
            signUpErrors.put("invalidPasswordFormat", "Password must contains one special char, one upercase letter, " +
                    "one lowercase letter, one number and 12 chars."
            );
        }

        if(signUp.password.equals(signUp.confirmPassword)){
            commonFingerprintingController.save("Passwords mismatch.");
            signUpErrors.put("passwordsError","Passwords mismatch.");
        }

        if(signUpErrors.size() != 0){
            return ok(Json.toJson(signUpErrors));
        }

        if(create(signUp)){
            commonFingerprintingController.save("Success. The user has been created.");
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "message", "Success. The user has been created."
                    )
            );
        }else {
            commonFingerprintingController.save("Error. The user could not be created.");
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "message", "The user could not be created."
                    )
            );
        }

    }

    public boolean checkUsername(String username){

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository
                = new FindCommonUserModelByUsernameRepository();
        if(findCommonUserModelByUsernameRepository.find(username) != null){
            return false;
        }
        return true;

    }

    public boolean checkEmail(String email){
        FindCommonUserModelByEmailRepository findCommonUserModelByEmailRepository =
                new FindCommonUserModelByEmailRepository();
        if(findCommonUserModelByEmailRepository.find(email) != null){
            return false;
        }
        return true;
    }

    public boolean checkPassword(String password){
        ValidatePassword validatePassword = new ValidatePassword();
        return validatePassword.isAcceptablePassword(password);
    }

    public boolean create(SignUp signUp){

        CreateCommonUserModelService createCommonUserModelService = new CreateCommonUserModelService();
        return createCommonUserModelService.create(
                signUp.username, signUp.email, signUp.password, "active", "user"
        );

    }

}
