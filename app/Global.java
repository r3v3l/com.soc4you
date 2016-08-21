import models.ContentTypeModel;
import models.JobTypeModel;
import models.RoleModel;
import models.StatusModel;
import play.Application;
import play.GlobalSettings;
import play.Logger;

import java.util.Date;

/**
 * Created by adrian on 19.08.16.
 */
public class Global extends GlobalSettings {

    public void onStart(Application app) {

        Logger.info("Application has started");
        createStatuses();
        createRoles();
        createContentTypes();

    }

    public void createStatuses(){

        if(StatusModel.rowCount() == 0){

            createStatus("active");
            createStatus("inactive");
            createStatus("frozen");
            createStatus("review");

        }

    }

    public void createRoles(){

        if(RoleModel.rowCount() == 0){

            createRole("user", "active");
            createRole("customer", "active");
            createRole("adviser", "active");
            createRole("author", "active");
            createRole("researcher", "active");
            createRole("editor", "active");
            createRole("moderator", "active");
            createRole("admin", "active");

        }

    }

    public void createContentTypes(){

        if(ContentTypeModel.rowCount() == 0){

            createContentType("guest", "active");
            createContentType("newsletter", "active");
            createContentType("register", "active");
            createContentType("advertise", "active");
            createContentType("paid", "active");

        }

    }

    public void createJobTypes(){

        if(JobTypeModel.rowCount() == 0){

            createJobType("partTitme", "active");
            createJobType("fullTime", "active");
            createJobType("freelance", "active");
            createJobType("intership", "active");
            createJobType("temporary", "active");
            createJobType("volonteur", "active");

        }

    }

    public void createStatus(String statusName){

        StatusModel statusModel = new StatusModel();
        statusModel.statusName = statusName;
        statusModel.creationDate = new Date();
        statusModel.updateDate = new Date();
        statusModel.save();

    }

    public void createRole(String roleName, String statusName){

        RoleModel roleModel = new RoleModel();
        roleModel.roleName = roleName;
        roleModel.roleStatus = StatusModel.findByName(statusName);
        roleModel.creationDate = new Date();
        roleModel.updateDate = new Date();
        roleModel.save();

    }

    public void createContentType(String typeName, String statusName){

        ContentTypeModel contentTypeModel = new ContentTypeModel();
        contentTypeModel.typeName = typeName;
        contentTypeModel.contentTypeStatus = StatusModel.findByName(statusName);
        contentTypeModel.creationDate = new Date();
        contentTypeModel.updateDate = new Date();
        contentTypeModel.save();

    }

    public void createJobType(String typeName, String statusName){

        JobTypeModel jobTypeModel = new JobTypeModel();
        jobTypeModel.typeName = typeName;
        jobTypeModel.jobTypeStatus = StatusModel.findByName(statusName);
        jobTypeModel.creationDate = new Date();
        jobTypeModel.updateDate = new Date();
        jobTypeModel.save();

    }

    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}
