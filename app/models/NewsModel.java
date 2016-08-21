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
public class NewsModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String name;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String title;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String smallImage;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String largeImage;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String description;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String keywords;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="newsStatus", referencedColumnName="id")
    public StatusModel newsStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="newsContentType", referencedColumnName="id")
    public ContentTypeModel newsContentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="newsCategory", referencedColumnName="id")
    public NewsCategoryModel newsCategory;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, NewsModel> find =
            new Finder<Long, NewsModel>(Long.class, NewsModel.class);

    public static List<NewsModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<NewsModel> findByStatus(StatusModel newsCategoryStatus){

        return find.where().eq("newsCategoryStatus", newsCategoryStatus).findList();

    }

    public static int rowCountByStatus(StatusModel newsCategoryStatus){

        return find.where().eq("newsCategoryStatus", newsCategoryStatus).findRowCount();

    }

    public static List<NewsModel> findByContentType(ContentTypeModel newsContentType){

        return find.where().eq("newsContentType", newsContentType).findList();

    }

    public static int rowCountByContentType(ContentTypeModel newsContentType){

        return find.where().eq("newsContentType", newsContentType).findRowCount();

    }

    public static List<NewsModel> findByCategory(NewsCategoryModel newsCategory){

        return find.where().eq("newsCategory", newsCategory).findList();

    }

    public static int rowCountByCategory(NewsCategoryModel newsCategory){

        return find.where().eq("newsCategory", newsCategory).findRowCount();

    }

    public static NewsModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static NewsModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static NewsModel findBySmallImage(String smallImage){

        try {

            return find.where().eq("smallImage", smallImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static NewsModel findByLargeImage(String largeImage){

        try {

            return find.where().eq("largeImage", largeImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static NewsModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static NewsModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
