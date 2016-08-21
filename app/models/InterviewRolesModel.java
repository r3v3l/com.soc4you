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
public class InterviewRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public InterviewModel interviewModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, InterviewRolesModel> find =
            new Finder<Long, InterviewRolesModel>(Long.class, InterviewRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<InterviewRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByNews(InterviewModel interviewModel){

        return find.where().eq("interviewModel", interviewModel).findRowCount();

    }

    public static List<InterviewRolesModel> findByNews(InterviewModel interviewModel){

        return find.where().eq("interviewModel", interviewModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<InterviewRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
