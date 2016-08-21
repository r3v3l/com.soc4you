package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 21.08.16.
 */
@Entity
public class UserFingerprintModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Constraints.Required
    public UserModel user;

    @Constraints.Required
    public String remoteAddress;

    @Constraints.Required
    public String currentHost;

    @Constraints.Required
    public String currentMethod;

    @Constraints.Required
    public String currentPath;

    @Constraints.Required
    public String currentUri;

    @Constraints.Required
    public String currentVersion;

    @Column(columnDefinition = "TEXT")
    @Constraints.Required
    public String userMessage;

    @Constraints.Required
    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date creationDate;

    public static Finder<Long, UserFingerprintModel> find = new Finder<Long, UserFingerprintModel>(
            Long.class, UserFingerprintModel.class
    );

    public static List<UserFingerprintModel> findAll(){

        return findAll();

    }

    public static List<UserFingerprintModel> findByUser(UserModel user){

        return find.where().eq("user", user).findList();

    }

    public static List<UserFingerprintModel> findByHost(String currentHost){

        return find.where().eq("currentHost", currentHost).findList();

    }

    public static List<UserFingerprintModel> findByMethod(String currentMethod){

        return find.where().eq("currentMethod", currentMethod).findList();

    }

    public static List<UserFingerprintModel> findByPath(String currentPath){

        return find.where().eq("currentPath", currentPath).findList();

    }

    public static List<UserFingerprintModel> findByUri(String currentUri){

        return find.where().eq("currentUri", currentUri).findList();

    }

    public static List<UserFingerprintModel> findByVersion(String currentVersion){

        return find.where().eq("currentVersion", currentVersion).findList();

    }

    public static List<UserFingerprintModel> findByRemoteAddress(String remoteAddress){

        return find.where().eq("remoteAddress", remoteAddress).findList();

    }

}
