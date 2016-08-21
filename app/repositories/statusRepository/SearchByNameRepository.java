package repositories.statusRepository;

import models.StatusModel;

/**
 * Created by adrian on 21.08.16.
 */
public class SearchByNameRepository {

    public static StatusModel search(String statusName){

        StatusModel statusModel = new StatusModel();
        try {

            statusModel = StatusModel.findByName(statusName);

        }catch (NullPointerException e){

            statusModel = null;

        }

        return statusModel;

    }

}
