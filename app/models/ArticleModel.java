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
public class ArticleModel extends Model {

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
    @JoinColumn(name="articleStatus", referencedColumnName="id")
    public StatusModel articleStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="articleContentType", referencedColumnName="id")
    public ContentTypeModel articleContentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="articleCategory", referencedColumnName="id")
    public ArticleCategoryModel articleCategory;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ArticleModel> find =
            new Finder<Long, ArticleModel>(Long.class, ArticleModel.class);

    public static List<ArticleModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ArticleModel> findByStatus(StatusModel articleStatus){

        return find.where().eq("articleStatus", articleStatus).findList();

    }

    public static int rowCountByStatus(StatusModel articleStatus){

        return find.where().eq("articleStatus", articleStatus).findRowCount();

    }

    public static List<ArticleModel> findByContentType(ContentTypeModel articleContentType){

        return find.where().eq("articleContentType", articleContentType).findList();

    }

    public static int rowCountByContentType(ContentTypeModel articleContentType){

        return find.where().eq("articleContentType", articleContentType).findRowCount();

    }

    public static List<ArticleModel> findByCategory(ArticleCategoryModel articleCategory){

        return find.where().eq("articleCategory", articleCategory).findList();

    }

    public static int rowCountByCategory(ArticleCategoryModel articleCategory){

        return find.where().eq("articleCategory", articleCategory).findRowCount();

    }

    public static ArticleModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ArticleModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ArticleModel findBySmallImage(String smallImage){

        try {

            return find.where().eq("smallImage", smallImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ArticleModel findByLargeImage(String largeImage){

        try {

            return find.where().eq("largeImage", largeImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ArticleModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ArticleModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
