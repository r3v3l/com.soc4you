package repositories.common.commonUserModel;

import models.common.CommonUserModel;

/**
 * Created by adrian on 25.08.16.
 */
public class AuthenticateUserByEmailRepository {

    public CommonUserModel findByEmail(String email, String password){

        CommonUserModel commonUserModel = new CommonUserModel();
        try {
            return commonUserModel.find.where()
                    .eq("email", email.toLowerCase())
                    .eq("shaPassword", commonUserModel.getSha512(password))
                    .findUnique();
        }catch (NullPointerException e){
            return null;
        }

    }

}
