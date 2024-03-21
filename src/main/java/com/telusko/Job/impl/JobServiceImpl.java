package com.telusko.Job.impl;

import com.telusko.Job.model.Job;
import com.telusko.Job.repo.JobRepo;
import com.telusko.Job.service.JobService;
import com.telusko.Job.dto.JobDTO;
import com.telusko.Job.external.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }
    private JobDTO convertJobToJobDTO(Job job) {
        JobDTO jobDTO = new JobDTO();
        RestTemplate restTemplate = new RestTemplate();
        jobDTO.setJob(job);
        Company company = restTemplate.getForObject("http://localhost:9092/companies/" + job.getCompanyId(), Company.class);
        jobDTO.setCompany(company);
        return jobDTO;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepo.findAll();
        return jobs.stream().map(this::convertJobToJobDTO).collect(Collectors.toList());

    }




    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }


    @Override
    public Job getJobById(Integer id) {
        return jobRepo.findById(id).get();
    }


    @Override
    public Boolean deleteJobById(Integer id) {

        jobRepo.deleteById(id);
        return true;
    }


    @Override
    public Job updatedJobById(Integer id, Job updatedJob) {
        Job job = jobRepo.findById(id).get();
        job.setMinSalary(updatedJob.getMinSalary());
        job.setMaxSalary(updatedJob.getMaxSalary());
        job.setLocation(updatedJob.getLocation());
        job.setDescription(updatedJob.getDescription());
        job.setTitle(updatedJob.getTitle());
        jobRepo.save(job);
        return job;

    }

}






