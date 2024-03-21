package com.telusko.Job.service;

import com.telusko.Job.dto.JobDTO;
import com.telusko.Job.model.Job;

import java.util.List;


public interface JobService {
    List<JobDTO> findAll();

    void createJob(Job job);

    JobDTO getJobById(Integer id);

    Boolean deleteJobById(Integer id);

    Job updatedJobById(Integer id, Job updatedJob);
}
