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
public class ArticleRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ArticleModel articleModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ArticleRolesModel> find =
            new Finder<Long, ArticleRolesModel>(Long.class, ArticleRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ArticleRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByArticle(ArticleModel articleModel){

        return find.where().eq("articleModel", articleModel).findRowCount();

    }

    public static List<ArticleRolesModel> findByArticle(ArticleModel articleModel){

        return find.where().eq("articleModel", articleModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ArticleRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
