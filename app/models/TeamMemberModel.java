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
public class TeamMemberModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberName;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberImage;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberFacebook;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberTwitter;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberSkype;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberLinkedIn;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String memberDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teamMemberStatus", referencedColumnName="id")
    public StatusModel teamMemberStatus;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, TeamMemberModel> find =
            new Finder<Long, TeamMemberModel>(Long.class, TeamMemberModel.class);

    public static List<TeamMemberModel> findAll(){

        return find.all();

    }

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<TeamMemberModel> findByStatus(StatusModel teamMemberStatus){

        return find.where().eq("teamMemberStatus", teamMemberStatus).findList();

    }

    public static int rowCountByStatus(StatusModel teamMemberStatus){

        return find.where().eq("teamMemberStatus", teamMemberStatus).findRowCount();

    }

    public static TeamMemberModel findByMemberName(String memberName){

        try {

            return find.where().eq("memberName", memberName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static TeamMemberModel findByFacebook(String memberFacebook){

        try {

            return find.where().eq("memberFacebook", memberFacebook).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static TeamMemberModel findByTwitter(String memberTwitter){

        try {

            return find.where().eq("memberTwitter", memberTwitter).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static TeamMemberModel findByLinkedIn(String memberLinkedIn){

        try {

            return find.where().eq("memberLinkedIn", memberLinkedIn).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static TeamMemberModel findBySkype(String memberSkype){

        try {

            return find.where().eq("memberSkype", memberSkype).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static TeamMemberModel findByImage(String memberImage){

        try {

            return find.where().eq("memberImage", memberImage).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
