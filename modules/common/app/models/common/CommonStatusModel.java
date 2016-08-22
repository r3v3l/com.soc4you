package models.common;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by adrian on 22.08.16.
 */
@Entity
public class CommonStatusModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.Required
    @Constraints.MinLength(1)
    @Constraints.MaxLength(255)
    public String statusName;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public Finder<Long, CommonStatusModel> find =
            new Finder<Long, CommonStatusModel>(Long.class, CommonStatusModel.class);

}
