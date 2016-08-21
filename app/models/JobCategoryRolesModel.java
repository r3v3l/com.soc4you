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
public class JobCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public JobCategoryModel jobCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, JobCategoryRolesModel> find =
            new Finder<Long, JobCategoryRolesModel>(Long.class, JobCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<JobCategoryRolesModel> findAll() {

        return find.all();

    }

    public static int rowCountByJob(JobCategoryModel jobCategoryModel){

        return find.where().eq("jobCategoryModel", jobCategoryModel).findRowCount();

    }

    public static List<JobCategoryRolesModel> findByJob(JobCategoryModel jobCategoryModel){

        return find.where().eq("jobCategoryModel", jobCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<JobCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
