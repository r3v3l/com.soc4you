package repositories.common.commonUserModel;

import models.common.AppUser;
import models.common.CommonUserModel;
import repositories.common.commonRoleModel.FindCommonRoleModelByRoleNameRepository;
import repositories.common.commonStatusModel.FindCommonStatusModelByStatusNameRepository;

import java.util.Date;

/**
 * Created by adrian on 23.08.16.
 */
public class CreateCommonUserModelRepository {

    public FindCommonRoleModelByRoleNameRepository findCommonRoleModelByRoleNameRepository =
            new FindCommonRoleModelByRoleNameRepository();
    public FindCommonStatusModelByStatusNameRepository findCommonStatusModelByStatusNameRepository =
            new FindCommonStatusModelByStatusNameRepository();

    public void create(AppUser appUser){

        CommonUserModel commonUserModel = new CommonUserModel();
        commonUserModel.username = appUser.username;
        commonUserModel.setEmail(appUser.email);
        commonUserModel.setPassword(appUser.password);
        commonUserModel.userStatus = findCommonStatusModelByStatusNameRepository.findByName(appUser.userStatusName);
        commonUserModel.userRole = findCommonRoleModelByRoleNameRepository.findByName(appUser.userRoleName);
        commonUserModel.creationDate = new Date();
        commonUserModel.updateDate = new Date();
        commonUserModel.save();

    }

}
