package repositories.common.commonStatusModel;

import models.common.CommonStatusModel;

import java.util.Date;

/**
 * Created by adrian on 22.08.16.
 */
public class CreateCommonStatusModel {

    public boolean create(String statusName){

        if(
                (statusName == null) || statusName.trim().equals("")
                ){

            return false;

        }

        FindCommonStatusModelByStatusName findCommonStatusModelByStatusName = new FindCommonStatusModelByStatusName();
        if(findCommonStatusModelByStatusName.findByName(statusName) != null){

            return false;

        }

        save(statusName);

        if(findCommonStatusModelByStatusName.findByName(statusName) != null){

            return true;

        }

        return false;

    }

    private void save(String statusName) {
        CommonStatusModel commonStatusModel = new CommonStatusModel();
        commonStatusModel.statusName = statusName;
        commonStatusModel.creationDate = new Date();
        commonStatusModel.updateDate = new Date();
        commonStatusModel.save();
    }

}