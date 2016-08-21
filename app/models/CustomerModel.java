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
public class CustomerModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false, unique = true)
    @Constraints.Required
    @OneToOne
    @JoinColumn(name = "id")
    public UserModel user;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MinLength(9)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String telephone;

    @Column(length = 255, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String companyName;

    @Column(length = 255, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String address;

    @Column(length = 255, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String city;

    @Column(length = 255, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String country;

    @Column(length = 255, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String postalCode;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String taxNumber;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, CustomerModel> find =
            new Finder<Long, CustomerModel>(Long.class, CustomerModel.class);

    public static CustomerModel findByUser(UserModel userModel){

        try {

            return find.where().eq("user", userModel).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static CustomerModel findByTaxNumber(String taxNumber){

        try {

            return find.where().eq("taxNumber", taxNumber).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

    public static CustomerModel findByTelephone(String telephone){

        try {

            return find.where().eq("telephone", telephone).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
