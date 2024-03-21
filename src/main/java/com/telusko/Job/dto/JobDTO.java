package com.telusko.Job.dto;

import com.telusko.Job.model.Job;
import com.telusko.Job.external.Company;
import lombok.Data;

@Data
public class JobDTO {

    private Job job;
    private Company company;
}
