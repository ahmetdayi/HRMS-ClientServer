package hrms.hrms.dataAccess.abstratcs;

import hrms.hrms.entities.concretes.JobAdvertisement;

import hrms.hrms.entities.dtos.JobAdvertisementDto;
import hrms.hrms.entities.dtos.JobAdvertisementWithEmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    JobAdvertisement getByJobId(int jobPositionId);
    JobAdvertisement getByJobName(String jobPositionName);
    JobAdvertisement deleteByJobId(int jobPositionId);

    @Query("Select new hrms.hrms.entities.dtos.JobAdvertisementWithEmployerDto"
            + "(j.jobName,j.jobDescription,j.jobCity,j.jobSalary,j.jobOpenPosition,j.deadlineDate, e.employerName) "
            + "From Employer e Inner Join e.jobAdvertisements j")
    List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerName();
}
