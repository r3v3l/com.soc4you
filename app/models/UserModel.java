package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 19.08.16.
 */
@Entity
public class UserModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MinLength(3)
    @Constraints.MaxLength(255)
    @Constraints.Required
    public String username;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.MaxLength(255)
    @Constraints.Required
    @Constraints.Email
    public String email;

    @Column(length = 64, nullable = false)
    private byte[] shaPassword;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userStatus", referencedColumnName="id")
    public StatusModel userStatus;

    @OneToOne(mappedBy = "user")
    public ProfileModel profile;

    @OneToOne(mappedBy = "user")
    public CustomerModel customer;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public void setPassword(String password) {
        this.shaPassword = getSha512(password);
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public static Finder<Long, UserModel> find = new Finder<Long, UserModel>(
            Long.class, UserModel.class);

    public static List<UserModel> findAll(){

        return find.all();

    }

    public static List<UserModel> findByStatus(StatusModel statusModel){

        return find.where().eq("userStatus", statusModel).findList();

    }

    public static UserModel findByEmailAndPassword(String email, String password) {
        return find
                .where()
                .eq("email", email.toLowerCase())
                .eq("shaPassword", getSha512(password))
                .findUnique();
    }

    public static UserModel findByUsernameAndPassword(String username, String password) {
        return find
                .where()
                .eq("username", username)
                .eq("shaPassword", getSha512(password))
                .findUnique();
    }

    public static UserModel findByEmail(String email) {
        return find
                .where()
                .eq("email", email.toLowerCase())
                .findUnique();
    }

    public static byte[] getSha512(String value) {
        try {
            return MessageDigest.getInstance("SHA-512").digest(value.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}