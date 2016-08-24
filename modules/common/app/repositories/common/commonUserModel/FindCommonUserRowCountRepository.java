package repositories.common.commonUserModel;

import models.common.CommonUserModel;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonUserRowCountRepository {

    public int rowCount(){

        CommonUserModel commonUserModel = new CommonUserModel();
        return commonUserModel.find.findRowCount();

    }

}
