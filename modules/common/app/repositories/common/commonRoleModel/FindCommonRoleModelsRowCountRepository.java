package repositories.common.commonRoleModel;

import models.common.CommonRoleModel;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonRoleModelsRowCountRepository {

    public int rowCount(){

        CommonRoleModel commonRoleModel = new CommonRoleModel();
        return commonRoleModel.find.findRowCount();

    }

}
