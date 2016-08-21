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
public class ReviewRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public ReviewModel reviewModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, ReviewRolesModel> find =
            new Finder<Long, ReviewRolesModel>(Long.class, ReviewRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ReviewRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByReview(ReviewModel reviewModel){

        return find.where().eq("reviewModel", reviewModel).findRowCount();

    }

    public static List<ReviewRolesModel> findByReview(ReviewModel reviewModel){

        return find.where().eq("reviewModel", reviewModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<ReviewRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
