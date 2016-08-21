package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 20.08.16.
 */
@Entity
public class JobRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public JobModel jobModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, JobRolesModel> find =
            new Finder<Long, JobRolesModel>(Long.class, JobRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<JobRolesModel> findAll() {

        return find.all();

    }

    public static int rowCountByJob(JobModel jobModel){

        return find.where().eq("jobModel", jobModel).findRowCount();

    }

    public static List<JobRolesModel> findByJob(JobModel jobModel){

        return find.where().eq("jobModel", jobModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<JobRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
