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
 * Created by adrian on 20.08.16.
 */
@Entity
public class OpeningHoursModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255)
    @Constraints.MinLength(1)
    @Constraints.MaxLength(255)
    public String week;

    @Column(length = 255)
    @Constraints.MinLength(1)
    @Constraints.MaxLength(255)
    public String saturday;

    @Column(length = 255)
    @Constraints.MinLength(1)
    @Constraints.MaxLength(255)
    public String sunday;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, OpeningHoursModel> find =
            new Finder<Long, OpeningHoursModel>(Long.class, OpeningHoursModel.class);

    public static List<OpeningHoursModel> findAll(){

        return find.all();

    }

}
