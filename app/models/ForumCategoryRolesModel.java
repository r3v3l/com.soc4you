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
public class ForumCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ForumCategoryModel forumCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ForumCategoryRolesModel> find =
            new Finder<Long, ForumCategoryRolesModel>(Long.class, ForumCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ForumCategoryRolesModel> findAll() {

        return find.all();

    }

    public static int rowCountByForumCategory(ForumCategoryModel forumCategoryModel){

        return find.where().eq("forumCategoryModel", forumCategoryModel).findRowCount();

    }

    public static List<ForumCategoryRolesModel> findByForumCategory(ForumCategoryModel forumCategoryModel){

        return find.where().eq("forumCategoryModel", forumCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ForumCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
