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
public class ContentTypeModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String typeName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contentTypeStatus", referencedColumnName="id")
    public StatusModel contentTypeStatus;

    @OneToMany(mappedBy = "articleContentType")
    public List<ArticleModel> articleModels;

    @OneToMany(mappedBy = "forumPostContentType")
    public List<ForumPostModel> forumPostModels;

    @OneToMany(mappedBy = "jobContentType")
    public List<JobModel> jobModels;

    @OneToMany(mappedBy = "newsContentType")
    public List<NewsModel> newsModels;

    @OneToMany(mappedBy = "reviewContentType")
    public List<ReviewModel> reviewModels;

    @OneToMany(mappedBy = "shopItemContentType")
    public List<ShopItemModel> shopItemModels;

    @OneToMany(mappedBy = "interviewContentType")
    public List<InterviewModel> interviewModel;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ContentTypeModel> find =
            new Finder<Long, ContentTypeModel>(Long.class, ContentTypeModel.class);

    public static List<ContentTypeModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<ContentTypeModel> findByStatus(StatusModel contentTypeStatus){

        return find.where().eq("contentTypeStatus", contentTypeStatus).findList();

    }

    public static int rowCountByStatus(StatusModel contentTypeStatus){

        return find.where().eq("contentTypeStatus", contentTypeStatus).findRowCount();

    }

    public static ContentTypeModel findByName(String typeName){

        try {

            return find.where().eq("typeName", typeName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
