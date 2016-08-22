import play.Application;
import play.GlobalSettings;
import play.Logger;
import repositories.common.commonStatusModel.CreateCommonStatusModel;
import repositories.common.commonStatusModel.FindCommonStatusModelsRowCount;

/**
 * Created by adrian on 19.08.16.
 */
public class Global extends GlobalSettings {

    public void onStart(Application app) {

        Logger.info("Application has started");

        createStatuses();

    }

    public void createStatuses(){

        FindCommonStatusModelsRowCount findCommonStatusModelsRowCount = new FindCommonStatusModelsRowCount();
        if(findCommonStatusModelsRowCount.rowCount() == 0){

            createStatus("active");
            createStatus("inactive");
            createStatus("blocked");
            createStatus("banned");
            createStatus("frozen");
            createStatus("offline");
            createStatus("online");

        }

    }

    public void createStatus(String statusName){

        CreateCommonStatusModel createCommonStatusModel = new CreateCommonStatusModel();
        if(createCommonStatusModel.create(statusName)){

            Logger.info("Status " +statusName+ " was created successfully.");

        }else {

            Logger.info("Status " +statusName+ " could not be created.");

        }

    }

    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}
