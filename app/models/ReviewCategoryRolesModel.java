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
public class ReviewCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ReviewCategoryModel reviewCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ReviewCategoryRolesModel> find =
            new Finder<Long, ReviewCategoryRolesModel>(Long.class, ReviewCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ReviewCategoryRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByReview(ReviewCategoryModel reviewCategoryModel){

        return find.where().eq("reviewCategoryModel", reviewCategoryModel).findRowCount();

    }

    public static List<ReviewCategoryRolesModel> findByReview(ReviewCategoryModel reviewCategoryModel){

        return find.where().eq("reviewCategoryModel", reviewCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ReviewCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
