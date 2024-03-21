package com.telusko.Job.external;

import lombok.Data;

@Data
public class Review {
    private Integer id;
    private String title;
    private String description;
    private double rating;
    private Integer companyId;
}
