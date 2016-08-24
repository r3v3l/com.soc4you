package services.common.userModelCommon;

import models.common.AppUser;
import models.common.CommonRoleModel;
import models.common.CommonStatusModel;
import repositories.common.commonRoleModel.FindCommonRoleModelByRoleNameRepository;
import repositories.common.commonStatusModel.FindCommonStatusModelByStatusNameRepository;
import repositories.common.commonUserModel.CreateCommonUserModelRepository;
import repositories.common.commonUserModel.FindCommonUserModelByEmailRepository;
import repositories.common.commonUserModel.FindCommonUserModelByUsernameRepository;

/**
 * Created by adrian on 24.08.16.
 */
public class CreateCommonUserModelService {

    public boolean create(

            String username, String email, String password, String userStatus, String userRole

    ){

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                new FindCommonUserModelByUsernameRepository();
        if(findCommonUserModelByUsernameRepository.find(username) != null){
            return false;
        }

        FindCommonUserModelByEmailRepository findCommonUserModelByEmailRepository =
                new FindCommonUserModelByEmailRepository();
        if(findCommonUserModelByEmailRepository.find(email) != null){
            return false;
        }

        FindCommonStatusModelByStatusNameRepository findCommonStatusModelByStatusNameRepository =
                new FindCommonStatusModelByStatusNameRepository();
        CommonStatusModel commonStatusModel = findCommonStatusModelByStatusNameRepository.findByName(userStatus);
        if(findCommonStatusModelByStatusNameRepository.findByName(userStatus) == null){
            return false;
        }

        FindCommonRoleModelByRoleNameRepository findCommonRoleModelByRoleNameRepository =
                new FindCommonRoleModelByRoleNameRepository();
        CommonRoleModel commonRoleModel = findCommonRoleModelByRoleNameRepository.findByName(userRole);
        if(commonRoleModel == null){
            return false;
        }

        AppUser appUser = new AppUser();
        appUser.username = username;
        appUser.email = email;
        appUser.password = password;
        appUser.userStatusName = userStatus;
        appUser.userRoleName = userRole;

        CreateCommonUserModelRepository createCommonUserModelRepository = new CreateCommonUserModelRepository();
        createCommonUserModelRepository.create(appUser);

        if(findCommonUserModelByUsernameRepository.find(username) == null){
            return false;
        }

        return true;

    }

}
