package models;

import play.data.validation.Constraints;

/**
 * Created by adrian on 21.08.16.
 */
public class SignUpUserModel {

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
