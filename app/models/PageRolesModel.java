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
public class PageRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public PageModel pageModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, PageRolesModel> find =
            new Finder<Long, PageRolesModel>(Long.class, PageRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<PageRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByPage(PageModel pageModel){

        return find.where().eq("pageModel", pageModel).findRowCount();

    }

    public static List<PageRolesModel> findByPage(PageModel pageModel){

        return find.where().eq("pageModel", pageModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<PageRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
