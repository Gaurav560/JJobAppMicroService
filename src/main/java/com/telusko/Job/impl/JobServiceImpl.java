package com.telusko.Job.impl;

import com.telusko.Job.dto.JobDTO;
import com.telusko.Job.external.Company;
import com.telusko.Job.external.Review;
import com.telusko.Job.mapper.JobMapper;
import com.telusko.Job.model.Job;
import com.telusko.Job.repo.JobRepo;
import com.telusko.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    RestTemplate restTemplate;

    private final JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    private JobDTO convertJobToJobDTO(Job job) {

        //  RestTemplate restTemplate=new RestTemplate();
        Company company = restTemplate.getForObject("http://COMPANY-APP-MICROSERVICE:9092/companies/" + job.getCompanyId(), Company.class);
        //   List<Review> reviews=restTemplate.exchange("http://REVIEW-APP-MICROSERVICE:9093/reviews"+job.getCompanyId(),);
      
        return JobMapper.mapToJobDTO(job,company);
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepo.findAll();
        return jobs
                .stream()
                .map(this::convertJobToJobDTO)
                .collect(Collectors.toList());

    }

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }


    @Override
    public JobDTO getJobById(Integer id) {

        Job job = jobRepo.findById(id).orElse(null);
        if (job!=null){
        return convertJobToJobDTO(job);
        }
return null;
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






