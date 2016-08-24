package models.common;

import play.data.validation.Constraints;

/**
 * Created by adrian on 23.08.16.
 */
public class AppUser {

    @Constraints.MaxLength(255)
    @Constraints.Required
    public String username;

    @Constraints.MaxLength(255)
    @Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.MaxLength(255)
    @Constraints.Required
    public String password;

    @Constraints.Required
    public String userStatusName;

    @Constraints.Required
    public String userRoleName;

}
