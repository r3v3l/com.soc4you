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
public class JobTypeModel extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 255, nullable = false, unique = true)
    @Constraints.Required
    @Constraints.MaxLength(255)
    public String typeName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="jobTypeStatus", referencedColumnName="id")
    public StatusModel jobTypeStatus;

    @OneToMany(mappedBy = "jobType")
    public List<JobModel> jobTypes;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date creationDate;

    @Column(nullable = false)
    @Constraints.Required
    @Formats.DateTime(pattern = "yyyy/mm/dd")
    public Date updateDate;

    public static Finder<Long, JobTypeModel> find = new Finder<Long, JobTypeModel>(Long.class, JobTypeModel.class);

    public static int rowCount(){

        return find.findRowCount();

    }

    public static List<JobTypeModel> findAll(){

        return find.all();

    }

    public static List<JobTypeModel> findByStatus(StatusModel statusModel){

        return find.where().eq("jobTypeStatus", statusModel).findList();

    }

    public static JobTypeModel findByName(String typeName){

        try {

            return find.where().eq("typeName", typeName).findUnique();

        }catch (NullPointerException e){

            return null;

        }

    }

}
