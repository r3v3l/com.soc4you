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
public class NewsCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public NewsCategoryModel newsCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, NewsCategoryRolesModel> find =
            new Finder<Long, NewsCategoryRolesModel>(Long.class, NewsCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<NewsCategoryRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByNews(NewsCategoryModel newsCategoryModel){

        return find.where().eq("newsCategoryModel", newsCategoryModel).findRowCount();

    }

    public static List<NewsCategoryRolesModel> findByNews(NewsCategoryModel newsCategoryModel){

        return find.where().eq("newsCategoryModel", newsCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<NewsCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
