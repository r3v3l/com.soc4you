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
public class PartnerLogoModel extends Model {

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partnerLogoStatus", referencedColumnName="id")
    public StatusModel partnerLogoStatus;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, PartnerLogoModel> find =
            new Finder<Long, PartnerLogoModel>(Long.class, PartnerLogoModel.class);

    public static List<PartnerLogoModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<PartnerLogoModel> findByStatus(StatusModel partnerLogoStatus){

        return find.where().eq("partnerLogoStatus", partnerLogoStatus).findList();

    }

    public static int rowCountByStatus(StatusModel partnerLogoStatus){

        return find.where().eq("partnerLogoStatus", partnerLogoStatus).findRowCount();

    }

    public static PartnerLogoModel findByPartnerName(String partnerName){

        try {

            return find.where().eq("partnerName", partnerName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PartnerLogoModel findByPartnerImage(String partnerImage){

        try {

            return find.where().eq("partnerImage", partnerImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PartnerLogoModel findByPartnerAlt(String partnerAlt){

        try {

            return find.where().eq("partnerAlt", partnerAlt).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static PartnerLogoModel findByPartnerTitle(String partnerTitle){

        try {

            return find.where().eq("partnerTitle", partnerTitle).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
