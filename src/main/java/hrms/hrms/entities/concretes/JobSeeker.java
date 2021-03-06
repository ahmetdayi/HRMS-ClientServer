package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobSeekers")
@PrimaryKeyJoinColumn(name = "jobSeekerId",referencedColumnName = "id")
public class JobSeeker extends User {



    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nationalityId",unique = true)
    private String nationalityId;

    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public JobSeeker(String firstName,String lastName,String nationalityId,Date birthDate,String email,String password,String matchingPassword){
        super(email, password,matchingPassword);
        this.firstName=firstName;
        this.birthDate=birthDate;
        this.lastName=lastName;
        this.nationalityId=nationalityId;

    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="jobSeeker")
    private List<Cv> cvs;
}
