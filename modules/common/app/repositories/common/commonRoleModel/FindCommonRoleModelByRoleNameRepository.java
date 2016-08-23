package repositories.common.commonRoleModel;

import models.common.CommonRoleModel;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonRoleModelByRoleNameRepository {

    public CommonRoleModel findByName(String roleName){

        CommonRoleModel commonRoleModel = new CommonRoleModel();
        try {
            return commonRoleModel.find.where().eq("roleName", roleName).findUnique();
        }catch (NullPointerException e){
            return null;
        }
    }

}
