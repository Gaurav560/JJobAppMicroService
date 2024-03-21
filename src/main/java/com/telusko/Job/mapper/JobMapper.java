package com.telusko.Job.mapper;

import com.telusko.Job.dto.JobDTO;
import com.telusko.Job.external.Company;
import com.telusko.Job.external.Review;
import com.telusko.Job.model.Job;

public class JobMapper {

    public static JobDTO mapToJobDTO(Job job, Company company){
JobDTO jobDTO=new JobDTO();
jobDTO.setId(job.getId());
jobDTO.setLocation(job.getLocation());
jobDTO.setCompany(company);
jobDTO.setTitle(job.getTitle());
jobDTO.setDescription(job.getDescription());
jobDTO.setMaxSalary(job.getMaxSalary());
jobDTO.setMinSalary(job.getMinSalary());

return jobDTO;
    }
}
