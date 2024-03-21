package com.telusko.Job.dto;

import com.telusko.Job.external.Company;
import com.telusko.Job.external.Review;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {

    private int id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
     private List<Review> reviews;
}
