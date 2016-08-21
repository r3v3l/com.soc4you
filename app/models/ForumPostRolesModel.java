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
public class ForumPostRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ForumCategoryModel forumPostModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ForumPostRolesModel> find =
            new Finder<Long, ForumPostRolesModel>(Long.class, ForumPostRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ForumPostRolesModel> findAll() {

        return find.all();

    }

    public static int rowCountByForumPost(ForumPostModel forumPostModel){

        return find.where().eq("forumPostModel", forumPostModel).findRowCount();

    }

    public static List<ForumPostRolesModel> findByForumPost(ForumPostModel forumPostModel){

        return find.where().eq("forumPostModel", forumPostModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ForumPostRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
