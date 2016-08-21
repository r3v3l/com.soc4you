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
public class ShopCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ShopCategoryModel shopCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ShopCategoryRolesModel> find =
            new Finder<Long, ShopCategoryRolesModel>(Long.class, ShopCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ShopCategoryRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByShopCategory(ShopCategoryModel shopCategoryModel){

        return find.where().eq("shopCategoryModel", shopCategoryModel).findRowCount();

    }

    public static List<ShopCategoryRolesModel> findByReview(ShopCategoryModel shopCategoryModel){

        return find.where().eq("shopCategoryModel", shopCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ShopCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
