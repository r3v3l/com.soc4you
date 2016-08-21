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
public class ArticleCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ArticleCategoryModel articleCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ArticleCategoryRolesModel> find =
            new Finder<Long, ArticleCategoryRolesModel>(Long.class, ArticleCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ArticleCategoryRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByArticle(ArticleCategoryModel articleCategoryModel){

        return find.where().eq("articleCategoryModel", articleCategoryModel).findRowCount();

    }

    public static List<ArticleCategoryRolesModel> findByArticle(ArticleCategoryModel articleCategoryModel){

        return find.where().eq("articleCategoryModel", articleCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ArticleCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
