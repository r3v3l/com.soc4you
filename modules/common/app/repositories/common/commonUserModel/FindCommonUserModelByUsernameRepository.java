package repositories.common.commonUserModel;

import models.common.CommonUserModel;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonUserModelByUsernameRepository {

    public CommonUserModel find(String username){

        CommonUserModel commonUserModel = new CommonUserModel();
        try {
            return commonUserModel.find.where().eq("username", username).findUnique();
        }catch (NullPointerException e){
            return null;
        }

    }

}
