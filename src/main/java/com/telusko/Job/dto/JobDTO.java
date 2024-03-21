package com.telusko.Job.dto;

import com.telusko.Job.external.Company;
import lombok.Data;

@Data
public class JobDTO {

    private int id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    // private Review review;
}
