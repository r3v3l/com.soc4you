package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by adrian on 16.08.16.
 */
@Entity
public class NewsletterModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    @Constraints.Email
    public String email;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    public static Finder<Long, NewsletterModel> find =
            new Finder<Long, NewsletterModel>(Long.class, NewsletterModel.class);

    public static NewsletterModel findByEmail(String email){

        try {

            return find.where().eq("email", email).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
