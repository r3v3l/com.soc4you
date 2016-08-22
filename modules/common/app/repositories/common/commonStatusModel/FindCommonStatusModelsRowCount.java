package repositories.common.commonStatusModel;

import models.common.CommonStatusModel;

/**
 * Created by adrian on 22.08.16.
 */
public class FindCommonStatusModelsRowCount {

    public int rowCount(){

        CommonStatusModel commonStatusModel = new CommonStatusModel();
        return commonStatusModel.find.findRowCount();

    }

}
