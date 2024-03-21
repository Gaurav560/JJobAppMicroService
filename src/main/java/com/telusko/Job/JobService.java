package com.telusko.Job;

import com.telusko.Job.dto.JobDTO;

import java.util.List;


public interface JobService {
    List<JobDTO> findAll();

    void createJob(Job job);

    Job getJobById(Integer id);

    Boolean deleteJobById(Integer id);

    Job updatedJobById(Integer id, Job updatedJob);
}
