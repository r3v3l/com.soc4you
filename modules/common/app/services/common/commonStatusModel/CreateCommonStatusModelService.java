package services.common.commonStatusModel;

import repositories.common.commonStatusModel.CreateCommonStatusModelRepository;
import repositories.common.commonStatusModel.FindCommonStatusModelByStatusNameRepository;

/**
 * Created by adrian on 23.08.16.
 */
public class CreateCommonStatusModelService {

    public boolean create(String statusName){

        if(
                (statusName == null) || statusName.trim().equals("")
                ){

            return false;

        }

        FindCommonStatusModelByStatusNameRepository findCommonStatusModelByStatusName =
                new FindCommonStatusModelByStatusNameRepository();
        if(findCommonStatusModelByStatusName.findByName(statusName) != null){

            return false;

        }

        CreateCommonStatusModelRepository commonStatusModelRepository = new CreateCommonStatusModelRepository();
        commonStatusModelRepository.create(statusName);

        if(findCommonStatusModelByStatusName.findByName(statusName) != null){

            return true;

        }

        return false;

    }

}
