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
public class ForumPostModel extends Model {

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
    @JoinColumn(name="forumPostStatus", referencedColumnName="id")
    public StatusModel forumPostStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="forumPostCategory", referencedColumnName="id")
    public ForumCategoryModel forumPostCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="forumPostStatus", referencedColumnName="id")
    public ContentTypeModel forumPostContentType;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ForumPostModel> find =
            new Finder<Long, ForumPostModel>(Long.class, ForumPostModel.class);

    public static List<ForumPostModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ForumPostModel> findByStatus(StatusModel forumCategoryStatus){

        return find.where().eq("forumCategoryStatus", forumCategoryStatus).findList();

    }

    public static int rowCountByStatus(StatusModel forumCategoryStatus){

        return find.where().eq("forumCategoryStatus", forumCategoryStatus).findRowCount();

    }

    public static List<ForumPostModel> findByContentType(ContentTypeModel forumPostContentType){

        return find.where().eq("forumPostContentType", forumPostContentType).findList();

    }

    public static int rowCountByContentType(ContentTypeModel forumPostContentType){

        return find.where().eq("forumPostContentType", forumPostContentType).findRowCount();

    }

    public static List<ForumPostModel> findByCategory(ForumCategoryModel forumPostCategory){

        return find.where().eq("forumPostCategory", forumPostCategory).findList();

    }

    public static int rowCountByCategory(ForumCategoryModel forumPostCategory){

        return find.where().eq("forumPostCategory", forumPostCategory).findRowCount();

    }

    public static ForumPostModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ForumPostModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ForumPostModel findByImage(String image){

        try {

            return find.where().eq("image", image).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ForumPostModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static ForumPostModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
