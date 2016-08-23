package repositories.common.commonStatusModel;

import models.common.CommonStatusModel;

/**
 * Created by adrian on 22.08.16.
 */
public class FindCommonStatusModelByStatusNameRepository {

    public CommonStatusModel findByName(String statusName){

        CommonStatusModel commonStatusModel = new CommonStatusModel();
        CommonStatusModel currentStatus = null;

        try {

            currentStatus = commonStatusModel.find.where().eq("statusName", statusName).findUnique();

        }catch (NullPointerException e){

            currentStatus = null;

        }

        return currentStatus;

    }

}
