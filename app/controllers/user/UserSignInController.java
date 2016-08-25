package controllers.user;

import controllers.common.CommonFingerprintingController;
import controllers.common.CommonJsonResponseController;
import helpers.common.CommonEmailValidatorHelper;
import models.common.CommonUserModel;
import play.data.Form;
import play.data.validation.Constraints;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.common.commonUserModel.AuthenticateUserByEmailRepository;
import repositories.common.commonUserModel.AuthenticateUserByUsernameRepository;

/**
 * Created by adrian on 25.08.16.
 */
public class UserSignInController extends Controller {

    public CommonFingerprintingController commonFingerprintingController = new CommonFingerprintingController();
    public CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();

    public static class SignIn {

        @Constraints.Required
        @Constraints.MinLength(1)
        @Constraints.MaxLength(255)
        public String userdata;

        @Constraints.Required
        @Constraints.MinLength(1)
        @Constraints.MaxLength(255)
        public String password;

    }

    public Result index(){

        Form<SignIn> signInForm = Form.form(SignIn.class).bindFromRequest();
        if(signInForm.hasErrors()){
            commonFingerprintingController.save("SignIn form error.");
            return ok(signInForm.errorsAsJson());
        }

        SignIn signIn = signInForm.get();

        CommonEmailValidatorHelper commonEmailValidatorHelper = new CommonEmailValidatorHelper();
        if(commonEmailValidatorHelper.isValidEmxailAddress(signIn.userdata)){
            return byEmail(signIn.userdata, signIn.password);
        }else {
            return byUsername(signIn.userdata, signIn.password);
        }

    }

    public Result byEmail(String email, String password){

        AuthenticateUserByEmailRepository authenticateUserByEmailRepository =
                new AuthenticateUserByEmailRepository();
        CommonUserModel commonUserModel = authenticateUserByEmailRepository.findByEmail(email, password);
        if(commonUserModel == null){
            commonFingerprintingController.save("User " +email+ " not found. Invalid email or password.");
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "message", "User " +email+ " not found. Invalid email or password."
                    )
            );
        }
        session().put("username", commonUserModel.username);
        session().put("userRole", commonUserModel.userRole.roleName);
        session().put("userStatus", commonUserModel.userStatus.statusName);

        commonFingerprintingController.save("Success. User " +commonUserModel.username+ " logged.");
        return ok(
                Json.toJson(commonUserModel)
        );
    }

    public Result byUsername(String username, String password){

        AuthenticateUserByUsernameRepository authenticateUserByUsernameRepository =
                new AuthenticateUserByUsernameRepository();
        CommonUserModel commonUserModel = authenticateUserByUsernameRepository.findByUserName(username, password);
        if(commonUserModel == null){
            commonFingerprintingController.save("User " +username+ " not found. Invalid username or password.");
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "message", "User " +username+ " not found. Invalid username or password."
                    )
            );
        }

        session().put("username", commonUserModel.username);
        session().put("userRole", commonUserModel.userRole.roleName);
        session().put("userStatus", commonUserModel.userStatus.statusName);

        commonFingerprintingController.save("Success. User " +commonUserModel.username+ " logged.");
        return ok(
                Json.toJson(commonUserModel)
        );

    }

}
