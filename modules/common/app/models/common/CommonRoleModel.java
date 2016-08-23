package models.common;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adrian on 23.08.16.
 */
@Entity
public class CommonRoleModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, unique = true, nullable = false)
    @Constraints.Required
    @Constraints.MinLength(1)
    @Constraints.MaxLength(255)
    public String roleName;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @ManyToOne
    @JoinColumn(name = "roleStatus", referencedColumnName = "id")
    public CommonStatusModel roleStatus;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public Finder<Long, CommonRoleModel> find = new Finder<Long, CommonRoleModel>(Long.class, CommonRoleModel.class);

}
