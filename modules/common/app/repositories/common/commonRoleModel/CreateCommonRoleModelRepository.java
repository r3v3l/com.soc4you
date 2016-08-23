package repositories.common.commonRoleModel;

import models.common.CommonRoleModel;
import repositories.common.commonStatusModel.FindCommonStatusModelByStatusNameRepository;

import java.util.Date;

/**
 * Created by adrian on 23.08.16.
 */
public class CreateCommonRoleModelRepository {

    public void create(String roleName, String statusName){

        FindCommonStatusModelByStatusNameRepository findCommonStatusModelByStatusName =
                new FindCommonStatusModelByStatusNameRepository();

        CommonRoleModel commonRoleModel = new CommonRoleModel();
        commonRoleModel.roleName = roleName;
        commonRoleModel.roleStatus = findCommonStatusModelByStatusName.findByName(statusName);
        commonRoleModel.creationDate = new Date();
        commonRoleModel.updateDate = new Date();
        commonRoleModel.save();

    }

}
