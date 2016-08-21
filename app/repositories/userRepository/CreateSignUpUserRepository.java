package repositories.userRepository;

import models.RoleModel;
import models.SignUpUserModel;
import models.UserModel;
import repositories.statusRepository.SearchByNameRepository;

import java.util.Date;

/**
 * Created by adrian on 21.08.16.
 */
public class CreateSignUpUserRepository {

    public static void createUser(SignUpUserModel signUpUserModel){

        UserModel userModel = new UserModel();
        userModel.setPassword(signUpUserModel.password);
        userModel.setEmail(signUpUserModel.email);
        userModel.userStatus = SearchByNameRepository.search("active");
        userModel.username = signUpUserModel.username;
        userModel.roles.add(RoleModel.findRoleByName("user"));
        userModel.creationDate = new Date();
        userModel.updateDate = new Date();
        userModel.save();

    }

}
