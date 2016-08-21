package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 19.08.16.
 */
@Entity
public class StatusModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String statusName;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    @OneToMany(mappedBy = "roleStatus")
    public List<RoleModel> roleModels;

    @OneToMany(mappedBy = "userStatus")
    public List<UserModel> userModels;

    @OneToMany(mappedBy = "pageStatus")
    public List<PageModel> pageModels;

    @OneToMany(mappedBy = "newsCategoryStatus")
    public List<NewsCategoryModel> newsCategoryModels;

    @OneToMany(mappedBy = "articleCategoryStatus")
    public List<ArticleCategoryModel> articleCategoryModels;

    @OneToMany(mappedBy = "reviewCategoryStatus")
    public List<ReviewCategoryModel> reviewCategoryModels;

    @OneToMany(mappedBy = "jobCategoryStatus")
    public List<JobCategoryModel> jobCategoryModels;

    @OneToMany(mappedBy = "forumCategoryStatus")
    public List<ForumCategoryModel> forumCategoryModels;

    @OneToMany(mappedBy = "contentTypeStatus")
    public List<ContentTypeModel> contentTypeModels;

    @OneToMany(mappedBy = "articleStatus")
    public List<ArticleModel> articleModels;

    @OneToMany(mappedBy = "forumPostStatus")
    public List<ForumPostModel> forumPostModels;

    @OneToMany(mappedBy = "jobTypeStatus")
    public List<JobTypeModel> jobTypeModels;

    @OneToMany(mappedBy = "jobStatus")
    public List<JobModel> jobModels;

    @OneToMany(mappedBy = "newsStatus")
    public List<NewsModel> newsModels;

    @OneToMany(mappedBy = "reviewStatus")
    public List<ReviewModel> reviewModels;

    @OneToMany(mappedBy = "shopCategoryStatus")
    public List<ShopCategoryModel> shopCategoryModels;

    @OneToMany(mappedBy = "shopItemStatus")
    public List<ShopItemModel> shopItemModels;

    @OneToMany(mappedBy = "portfolioCategoryStatus")
    public List<PortfolioCategoryModel> portfolioCategoryModels;

    @OneToMany(mappedBy = "portfolioItemStatus")
    public List<PortfolioItemModel> portfolioItemModels;

    @OneToMany(mappedBy = "interviewStatus")
    public List<InterviewModel> interviewModels;

    @OneToMany(mappedBy = "serviceStatus")
    public List<ServiceModel> serviceModels;

    @OneToMany(mappedBy = "teamMemberStatus")
    public List<TeamMemberModel> teamMemberModels;

    @OneToMany(mappedBy = "partnerLogoStatus")
    public List<PartnerLogoModel> partnerLogoModels;

    @OneToMany(mappedBy = "partnerReviewStatus")
    public List<PartnerReviewModel> partnerReviewModels;

    public static Finder<Long, StatusModel> find = new Finder<Long, StatusModel>(Long.class, StatusModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<StatusModel> findAll(){

        return find.all();

    }

    public static StatusModel findByName(String statusName){

        try {

            return find.where().eq("statusName", statusName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
