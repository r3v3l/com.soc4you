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
public class PartnerReviewModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String partnerName;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String partnerImage;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String partnerAlt;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String partnerTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String partnerReview;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partnerReviewStatus", referencedColumnName="id")
    public StatusModel partnerReviewStatus;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, PartnerReviewModel> find =
            new Finder<Long, PartnerReviewModel>(Long.class, PartnerReviewModel.class);

    public static List<PartnerReviewModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<PartnerReviewModel> findByStatus(StatusModel partnerLogoStatus){

        return find.where().eq("partnerLogoStatus", partnerLogoStatus).findList();

    }

    public static int rowCountByStatus(StatusModel partnerLogoStatus){

        return find.where().eq("partnerLogoStatus", partnerLogoStatus).findRowCount();

    }

    public static PartnerReviewModel findByPartnerName(String partnerName){

        try {

            return find.where().eq("partnerName", partnerName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PartnerReviewModel findByPartnerImage(String partnerImage){

        try {

            return find.where().eq("partnerImage", partnerImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PartnerReviewModel findByPartnerAlt(String partnerAlt){

        try {

            return find.where().eq("partnerAlt", partnerAlt).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PartnerReviewModel findByPartnerTitle(String partnerTitle){

        try {

            return find.where().eq("partnerTitle", partnerTitle).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
