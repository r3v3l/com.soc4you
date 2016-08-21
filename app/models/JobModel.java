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
public class JobModel extends Model {

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

    @Column(length = 255, nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String companyName;

    @Column(length = 255, nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String location;

    @Column(length = 255, nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String jobPrice;

    @Column(length = 255, nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String deliveryTime;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String overview;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String benefits;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String qualifications;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="jobStatus", referencedColumnName="id")
    public StatusModel jobStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="jobCategory", referencedColumnName="id")
    public JobCategoryModel jobCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="jobType", referencedColumnName="id")
    public JobTypeModel jobType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="jobContentType", referencedColumnName="id")
    public StatusModel jobContentType;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, JobModel> find =
            new Finder<Long, JobModel>(Long.class, JobModel.class);

    public static List<JobModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<JobModel> findByStatus(StatusModel jobStatus){

        return find.where().eq("jobStatus", jobStatus).findList();

    }

    public static int rowCountByStatus(StatusModel jobStatus){

        return find.where().eq("jobStatus", jobStatus).findRowCount();

    }

    public static List<JobModel> findByCompanyName(String companyName){

        return find.where().eq("companyName", companyName).findList();

    }

    public static int rowCountByCompanyName(String companyName){

        return find.where().eq("companyName", companyName).findRowCount();

    }

    public static List<JobModel> findByLocation(String location){

        return find.where().eq("location", location).findList();

    }

    public static int rowCountByLocation(String location){

        return find.where().eq("location", location).findRowCount();

    }

    public static List<JobModel> findByDeliveryTime(String deliveryTime){

        return find.where().eq("deliveryTime", deliveryTime).findList();

    }

    public static int rowCountByDeliveryTime(String deliveryTime){

        return find.where().eq("deliveryTime", deliveryTime).findRowCount();

    }

    public static List<JobModel> findByCategory(JobCategoryModel jobCategory){

        return find.where().eq("jobCategory", jobCategory).findList();

    }

    public static int rowCountByCategory(JobCategoryModel jobCategory){

        return find.where().eq("jobCategory", jobCategory).findRowCount();

    }

    public static List<JobModel> findByJobType(JobTypeModel jobType){

        return find.where().eq("jobType", jobType).findList();

    }

    public static int rowCountByJobType(JobTypeModel jobType){

        return find.where().eq("jobType", jobType).findRowCount();

    }

    public static List<JobModel> findByContentType(ContentTypeModel jobContentType){

        return find.where().eq("jobContentType", jobContentType).findList();

    }

    public static int rowCountByContentType(ContentTypeModel jobContentType){

        return find.where().eq("jobContentType", jobContentType).findRowCount();

    }

    public static JobModel findByName(String name){

        try {

            return find.where().eq("name", name).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static JobModel findByTitle(String title){

        try {

            return find.where().eq("title", title).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static JobModel findBySmallImage(String smallImage){

        try {

            return find.where().eq("smallImage", smallImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static JobModel findByLargeImage(String largeImage){

        try {

            return find.where().eq("largeImage", largeImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static JobModel findByDescription(String description){

        try {

            return find.where().eq("description", description).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static JobModel findByKeywords(String keywords){

        try {

            return find.where().eq("keywords", keywords).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
