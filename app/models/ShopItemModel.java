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
public class ShopItemModel extends Model {

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
    @JoinColumn(name="shopItemStatus", referencedColumnName="id")
    public StatusModel shopItemStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shopItemContentType", referencedColumnName="id")
    public ContentTypeModel shopItemContentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shopItemCategory", referencedColumnName="id")
    public ReviewCategoryModel shopItemCategory;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ShopItemModel> find =
            new Finder<Long, ShopItemModel>(Long.class, ShopItemModel.class);

    public static List<ShopItemModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ShopItemModel> findByStatus(StatusModel shopItemStatus){

        return find.where().eq("shopItemStatus", shopItemStatus).findList();

    }

    public static int rowCountByStatus(StatusModel shopItemStatus){

        return find.where().eq("shopItemStatus", shopItemStatus).findRowCount();

    }

    public static List<ShopItemModel> findByContentType(ContentTypeModel shopItemContentType){

        return find.where().eq("shopItemContentType", shopItemContentType).findList();

    }

    public static int rowCountByContentType(ContentTypeModel shopItemContentType){

        return find.where().eq("shopItemContentType", shopItemContentType).findRowCount();

    }

    public static List<ShopItemModel> findByCategory(ShopCategoryModel shopItemCategory){

        return find.where().eq("shopItemCategory", shopItemCategory).findList();

    }

    public static int rowCountByCategory(ShopCategoryModel shopItemCategory){

        return find.where().eq("shopItemCategory", shopItemCategory).findRowCount();

    }

    public static ShopItemModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ShopItemModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ShopItemModel findBySmallImage(String smallImage){

        try {

            return find.where().eq("smallImage", smallImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ShopItemModel findByLargeImage(String largeImage){

        try {

            return find.where().eq("largeImage", largeImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ShopItemModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ShopItemModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
