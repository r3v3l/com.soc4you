package controllers;

import helpers.EmailValidator;
import helpers.NewPasswordValidator;
import models.SignUpUserModel;
import play.data.Form;
import play.data.validation.Constraints;
import play.filters.csrf.AddCSRFToken;
import play.mvc.Controller;
import play.mvc.Result;
import services.userModel.CheckUserEmailService;
import services.userModel.CheckUsernameService;
import services.userModel.CreateSignUpUserService;
import ui.messages.pl.signup.*;

/**
 * Created by adrian on 21.08.16.
 */
public class UserActionController extends Controller {

    public static class ForgotPassword {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String userData;

    }

    public static class SignIn extends ForgotPassword {

        @Constraints.Required
        @Constraints.MaxLength(255)
        public String password;

        public String rememberme;

    }

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
        @Constraints.Email
        public String password;

        @Constraints.Required
        @Constraints.MaxLength(255)
        @Constraints.Email
        public String confirmPassword;

    }

    @AddCSRFToken
    public Result index(){

        UserFingerprintController.saveData("User action page.");
        return ok(
                views.html.userAction.index.render(
                        flash("signUpFormErrors"), flash("signUpFormWarning"), flash("signUpFormSuccess")
                )
        );

    }

    public Result signIn(){

        return ok();

    }

    public Result forgotPassword(){

        return ok();

    }

}
