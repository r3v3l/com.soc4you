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
public class PortfolioItemModel extends Model {

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
    @JoinColumn(name="portfolioItemStatus", referencedColumnName="id")
    public StatusModel portfolioItemStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="poertfolioCategory", referencedColumnName="id")
    public PortfolioCategoryModel portfolioCategory;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, PortfolioItemModel> find =
            new Finder<Long, PortfolioItemModel>(Long.class, PortfolioItemModel.class);

    public static List<PortfolioItemModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<PortfolioItemModel> findByStatus(StatusModel portfolioItemStatus){

        return find.where().eq("portfolioItemStatus", portfolioItemStatus).findList();

    }

    public static int rowCountByStatus(StatusModel portfolioItemStatus){

        return find.where().eq("portfolioItemStatus", portfolioItemStatus).findRowCount();

    }

    public static List<PortfolioItemModel> findByCategory(PortfolioCategoryModel portfolioCategory){

        return find.where().eq("portfolioCategory", portfolioCategory).findList();

    }

    public static int rowCountByCategory(PortfolioCategoryModel portfolioCategory){

        return find.where().eq("portfolioCategory", portfolioCategory).findRowCount();

    }

    public static PortfolioItemModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PortfolioItemModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PortfolioItemModel findBySmallImage(String smallImage){

        try {

            return find.where().eq("smallImage", smallImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PortfolioItemModel findByLargeImage(String largeImage){

        try {

            return find.where().eq("largeImage", largeImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PortfolioItemModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PortfolioItemModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
