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
public class PortfolioItemRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public PortfolioItemModel portfolioItemModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, PortfolioItemRolesModel> find =
            new Finder<Long, PortfolioItemRolesModel>(Long.class, PortfolioItemRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<PortfolioItemRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByPortfolioItem(PortfolioItemModel portfolioItemModel){

        return find.where().eq("portfolioItemModel", portfolioItemModel).findRowCount();

    }

    public static List<PortfolioItemRolesModel> findByPortfolioItem(PortfolioItemModel portfolioItemModel){

        return find.where().eq("portfolioItemModel", portfolioItemModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<PortfolioItemRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
