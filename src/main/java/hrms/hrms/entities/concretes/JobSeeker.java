package hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hrms.hrms.core.entities.BaseEntity;
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
public class JobSeeker extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobSeekerId")
    private int jobSeekerId;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "nationalityId",nullable = false,unique = true,length = 11)
    private Long nationalityId;

    @Column(name = "birthDate",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jobSeeker")
    private List<Cv> cvs;
}
