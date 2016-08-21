package services.userModel;

import models.SignUpUserModel;
import models.UserModel;
import repositories.userRepository.CreateSignUpUserRepository;
import repositories.userRepository.SearchByUserNameRepository;

/**
 * Created by adrian on 21.08.16.
 */
public class CreateSignUpUserService {

    public static boolean createUser(SignUpUserModel signUpUserModel){

        CreateSignUpUserRepository.createUser(signUpUserModel);
        UserModel userModel = SearchByUserNameRepository.searchByName(signUpUserModel.username);
        if(userModel == null){

            return false;

        }

        return true;

    }

}
