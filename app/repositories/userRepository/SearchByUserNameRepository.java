package repositories.userRepository;

import models.UserModel;

/**
 * Created by adrian on 21.08.16.
 */
public class SearchByUserNameRepository {

    public static UserModel searchByName(String username){

        UserModel user = new UserModel();
        try {

            user = UserModel.find.where().eq("username", username).findUnique();

        }catch (NullPointerException e){

            user = null;

        }

        return user;

    }

}
