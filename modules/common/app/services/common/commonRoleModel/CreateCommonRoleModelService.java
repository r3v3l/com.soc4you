package services.common.commonRoleModel;

import repositories.common.commonRoleModel.CreateCommonRoleModelRepository;
import repositories.common.commonRoleModel.FindCommonRoleModelByRoleNameRepository;
import repositories.common.commonStatusModel.FindCommonStatusModelByStatusNameRepository;

/**
 * Created by adrian on 23.08.16.
 */
public class CreateCommonRoleModelService {

    public boolean create(String roleName, String statusName){

        FindCommonStatusModelByStatusNameRepository findCommonStatusModelByStatusNameRepository =
                new FindCommonStatusModelByStatusNameRepository();
        if(findCommonStatusModelByStatusNameRepository.findByName(statusName) == null){
            return false;
        }

        FindCommonRoleModelByRoleNameRepository findCommonRoleModelByRoleNameRepository =
                new FindCommonRoleModelByRoleNameRepository();
        if(findCommonRoleModelByRoleNameRepository.findByName(roleName) != null){
            return false;
        }

        CreateCommonRoleModelRepository createCommonRoleModelRepository = new CreateCommonRoleModelRepository();
        createCommonRoleModelRepository.create(roleName, statusName);

        if(findCommonRoleModelByRoleNameRepository.findByName(roleName) == null){
            return false;
        }

        return true;

    }

}
