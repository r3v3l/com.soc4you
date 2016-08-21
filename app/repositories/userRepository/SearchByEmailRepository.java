package repositories.userRepository;

import models.UserModel;

/**
 * Created by adrian on 21.08.16.
 */
public class SearchByEmailRepository {

    public static UserModel searchByEmail(String email){

        UserModel userModel = new UserModel();
        try {

            userModel = UserModel.findByEmail(email);

        }catch (NullPointerException e){

            userModel = null;

        }

        return userModel;

    }

}
