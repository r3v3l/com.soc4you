package repositories.common.commonUserModel;

import models.common.CommonUserModel;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonUserModelByEmailRepository {

    public CommonUserModel find(String email){

        CommonUserModel commonUserModel = new CommonUserModel();
        try {
            return commonUserModel.find.where().eq("email", email).findUnique();
        }catch (NullPointerException e){
            return null;
        }

    }

}
