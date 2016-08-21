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
public class PortfolioCategoryRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public PortfolioCategoryModel portfolioCategoryModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, PortfolioCategoryRolesModel> find =
            new Finder<Long, PortfolioCategoryRolesModel>(Long.class, PortfolioCategoryRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<PortfolioCategoryRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByPortfolioCategory(PortfolioCategoryModel portfolioCategoryModel){

        return find.where().eq("portfolioCategoryModel", portfolioCategoryModel).findRowCount();

    }

    public static List<PortfolioCategoryRolesModel> findByPortfolioCategory(PortfolioCategoryModel portfolioCategoryModel){

        return find.where().eq("portfolioCategoryModel", portfolioCategoryModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<PortfolioCategoryRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
