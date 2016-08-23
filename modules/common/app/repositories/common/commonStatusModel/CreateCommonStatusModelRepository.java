package repositories.common.commonStatusModel;

import models.common.CommonStatusModel;

import java.util.Date;

/**
 * Created by adrian on 22.08.16.
 */
public class CreateCommonStatusModelRepository {

    public void create(String statusName) {
        CommonStatusModel commonStatusModel = new CommonStatusModel();
        commonStatusModel.statusName = statusName;
        commonStatusModel.creationDate = new Date();
        commonStatusModel.updateDate = new Date();
        commonStatusModel.save();
    }

}