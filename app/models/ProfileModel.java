package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adrian on 19.08.16.
 */
@Entity
public class ProfileModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false, unique = true)
    @Constraints.Required
    @OneToOne
    @JoinColumn(name = "id")
    public UserModel user;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String firstname;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String lastname;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String profileImage;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Constraints.MinLength(3)
    @Constraints.Required
    public String biography;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, ProfileModel> find = new Finder<Long, ProfileModel>(Long.class, ProfileModel.class);


    public static ProfileModel findByUser(UserModel userModel){

        try {

            return find.where().eq("user", userModel).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
