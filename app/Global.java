import play.Application;
import play.GlobalSettings;
import play.Logger;
import repositories.common.commonRoleModel.FindCommonRoleModelsRowCountRepository;
import repositories.common.commonStatusModel.FindCommonStatusModelsRowCountRepository;
import services.common.commonRoleModel.CreateCommonRoleModelService;
import services.common.commonStatusModel.CreateCommonStatusModelService;

/**
 * Created by adrian on 19.08.16.
 */
public class Global extends GlobalSettings {

    public void onStart(Application app) {

        Logger.info("Application has started");

        createStatuses();
        createRoles();

    }

    public void createStatuses(){

        FindCommonStatusModelsRowCountRepository findCommonStatusModelsRowCount =
                new FindCommonStatusModelsRowCountRepository();
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

    public void createRoles(){

        FindCommonRoleModelsRowCountRepository findCommonRoleModelsRowCountRepository =
                new FindCommonRoleModelsRowCountRepository();
        if(findCommonRoleModelsRowCountRepository.rowCount() == 0){

            createRole("guest", "active");
            createRole("user", "active");
            createRole("customer", "active");
            createRole("advertiser", "active");
            createRole("developer", "active");
            createRole("qa", "active");
            createRole("author", "active");
            createRole("editor", "active");
            createRole("moderator", "active");
            createRole("admin", "active");
            createRole("business", "active");

        }

    }

    public void createStatus(String statusName){

        CreateCommonStatusModelService createCommonStatusModel = new CreateCommonStatusModelService();
        if(createCommonStatusModel.create(statusName)){

            Logger.info("Status " +statusName+ " was created successfully.");

        }else {

            Logger.info("Status " +statusName+ " could not be created.");

        }

    }

    public void createRole(String roleName, String statusName){

        CreateCommonRoleModelService createCommonRoleModelService = new CreateCommonRoleModelService();
        if(createCommonRoleModelService.create(roleName, statusName)){

            Logger.info("Role " +roleName+ " was created successfully.");

        }

        Logger.info("Status " +roleName+ " could not be created.");

    }

    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}
