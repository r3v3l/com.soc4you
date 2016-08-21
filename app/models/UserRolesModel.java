package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 19.08.16.
 */
@Entity
public class UserRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public UserModel userModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, UserRolesModel> find =
            new Finder<Long, UserRolesModel>(Long.class, UserRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<UserRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByUser(UserModel userModel){

        return find.where().eq("userModel", userModel).findRowCount();

    }

    public static List<UserRolesModel> findByUser(UserModel userModel){

        return find.where().eq("userModel", userModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<UserRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
