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
public class ReviewCategoryModel extends Model {

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
    public String image;

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
    @JoinColumn(name="reviewCategoryStatus", referencedColumnName="id")
    public StatusModel reviewCategoryStatus;

    @OneToMany(mappedBy = "reviewCategory")
    public List<ReviewModel> reviewsCategories;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ReviewCategoryModel> find =
            new Finder<Long, ReviewCategoryModel>(Long.class, ReviewCategoryModel.class);

    public static List<ReviewCategoryModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ReviewCategoryModel> findByStatus(StatusModel reviewCategoryStatus){

        return find.where().eq("reviewCategoryStatus", reviewCategoryStatus).findList();

    }

    public static int rowCountByStatus(StatusModel reviewCategoryStatus){

        return find.where().eq("reviewCategoryStatus", reviewCategoryStatus).findRowCount();

    }

    public static ReviewCategoryModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewCategoryModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewCategoryModel findByImage(String image){

        try {

            return find.where().eq("image", image).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewCategoryModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ReviewCategoryModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
