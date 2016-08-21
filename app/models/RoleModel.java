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
public class RoleModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String roleName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="roleStatus", referencedColumnName="id")
    public StatusModel roleStatus;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    @ManyToMany
    public List<UserModel> users;

    public static Finder<Long, RoleModel> find = new Finder<Long, RoleModel>(Long.class, RoleModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<RoleModel> findAll(){

        return find.all();

    }

    public static List<RoleModel> findRoleByStatus(StatusModel statusModel){

        return find.where().eq("roleStatus", statusModel).findList();

    }

    public static RoleModel findRoleByName(String roleName){

        try {

            return find.where().eq("roleName", roleName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
