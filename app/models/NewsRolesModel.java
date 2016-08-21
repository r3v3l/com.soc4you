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
public class NewsRolesModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    @ManyToMany
    public NewsModel newsModel;

    @Column(nullable = false)
    @ManyToMany
    public UserModel roleModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, NewsRolesModel> find =
            new Finder<Long, NewsRolesModel>(Long.class, NewsRolesModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<NewsRolesModel> findAll(){

        return find.all();

    }

    public static int rowCountByNews(NewsModel newsModel){

        return find.where().eq("newsModel", newsModel).findRowCount();

    }

    public static List<NewsRolesModel> findByNews(NewsModel newsModel){

        return find.where().eq("newsModel", newsModel).findList();

    }

    public static int rowCountByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findRowCount();

    }

    public static List<NewsRolesModel> findByRole(RoleModel roleModel){

        return find.where().eq("roleModel", roleModel).findList();

    }

}
