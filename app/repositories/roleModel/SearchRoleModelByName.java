package repositories.roleModel;

import models.RoleModel;

/**
 * Created by adrian on 21.08.16.
 */
public class SearchRoleModelByName {

    public static RoleModel searchByName(String name){

        RoleModel roleModel = new RoleModel();

        try {

            roleModel = RoleModel.findRoleByName(name);

        }catch (NullPointerException e){

            roleModel = null;

        }

        return roleModel;

    }

}
