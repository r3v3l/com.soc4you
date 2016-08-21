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
public class ReviewModel extends Model {

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
    @JoinColumn(name="reviewStatus", referencedColumnName="id")
    public StatusModel reviewStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reviewContentType", referencedColumnName="id")
    public ContentTypeModel reviewContentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reviewCategory", referencedColumnName="id")
    public ReviewCategoryModel reviewCategory;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ReviewModel> find =
            new Finder<Long, ReviewModel>(Long.class, ReviewModel.class);

    public static List<ReviewModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ReviewModel> findByStatus(StatusModel reviewCategoryStatus){

        return find.where().eq("reviewCategoryStatus", reviewCategoryStatus).findList();

    }

    public static int rowCountByStatus(StatusModel reviewCategoryStatus){

        return find.where().eq("reviewCategoryStatus", reviewCategoryStatus).findRowCount();

    }

    public static List<ReviewModel> findByContentType(ContentTypeModel reviewContentType){

        return find.where().eq("reviewContentType", reviewContentType).findList();

    }

    public static int rowCountByContentType(ContentTypeModel reviewContentType){

        return find.where().eq("reviewContentType", reviewContentType).findRowCount();

    }

    public static List<ReviewModel> findByCategory(ReviewCategoryModel reviewCategory){

        return find.where().eq("reviewCategory", reviewCategory).findList();

    }

    public static int rowCountByCategory(ReviewCategoryModel reviewCategory){

        return find.where().eq("reviewCategory", reviewCategory).findRowCount();

    }

    public static ReviewModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewModel findBySmallImage(String smallImage){

        try {

            return find.where().eq("smallImage", smallImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewModel findByLargeImage(String largeImage){

        try {

            return find.where().eq("largeImage", largeImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
