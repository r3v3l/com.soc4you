package controllers.user;

import controllers.common.CommonFingerprintingController;
import controllers.common.CommonJsonResponseController;
import helpers.common.CommonEmailValidatorHelper;
import helpers.common.CommonPasswordGeneratorHelper;
import models.common.CommonUserModel;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.common.commonUserModel.AuthenticateUserByUsernameRepository;
import repositories.common.commonUserModel.FindCommonUserModelByEmailRepository;
import repositories.common.commonUserModel.FindCommonUserModelByUsernameRepository;

import java.util.Date;

/**
 * Created by adrian on 27.08.16.
 */
public class UserForgotPasswordController extends Controller {

    public CommonFingerprintingController commonFingerprintingController = new CommonFingerprintingController();

    public static class Forgot {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String userdata;

    }

    public Result index(){

        Form<Forgot> forgotForm = Form.form(Forgot.class).bindFromRequest();
        if(forgotForm.hasErrors()){
            commonFingerprintingController.save("Forgot form errors.");
            return ok(forgotForm.errorsAsJson());
        }

        Forgot forgot = forgotForm.get();
        CommonEmailValidatorHelper emailValidatorHelper = new CommonEmailValidatorHelper();
        if(emailValidatorHelper.isValidEmxailAddress(forgot.userdata)){
            return changeWithEmail(forgot.userdata);
        }

        return changeWithUsername(forgot.userdata);

    }

    public Result changeWithEmail(String email){

        FindCommonUserModelByEmailRepository findCommonUserModelByEmailRepository =
                new FindCommonUserModelByEmailRepository();
        CommonUserModel commonUserModel = findCommonUserModelByEmailRepository.find(email);
        if(commonUserModel == null){
            commonFingerprintingController.save("User " +email+ " not exists. Please try again.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "error", "User " +email+ " not exists. Please try again."
                    )
            );
        }

        return createNewPassword(commonUserModel);

    }

    public Result changeWithUsername(String username){

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                new FindCommonUserModelByUsernameRepository();
        CommonUserModel commonUserModel = findCommonUserModelByUsernameRepository.find(username);
        if(commonUserModel == null){
            commonFingerprintingController.save("User " +username+ " not exists.");
            CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
            return ok(commonJsonResponseController.buildJsonResponse("error", "User " +username+ " not exists."));
        }

        return createNewPassword(commonUserModel);

    }

    public Result createNewPassword(CommonUserModel commonUserModel){

        CommonPasswordGeneratorHelper commonPasswordGeneratorHelper = new CommonPasswordGeneratorHelper();
        String password = commonPasswordGeneratorHelper.generateRandomString(12,20,1,1,1,1);
        commonUserModel.setPassword(password);
        commonUserModel.updateDate = new Date();
        commonUserModel.save();

        AuthenticateUserByUsernameRepository authenticateUserByUsernameRepository =
                new AuthenticateUserByUsernameRepository();
        CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
        if(authenticateUserByUsernameRepository.findByUserName(commonUserModel.username, password) == null){
            commonFingerprintingController.save("Error. Application can not change your password.");
            return ok(
                    commonJsonResponseController.buildJsonResponse(
                            "error", "Error. Application can not change your password."
                    )
            );
        }

        commonFingerprintingController.save("Password changed");
        return ok(commonJsonResponseController.buildJsonResponse("message", "Password changed."));

    }

}
