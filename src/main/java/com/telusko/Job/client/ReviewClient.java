package com.telusko.Job.client;

import com.telusko.Job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW-APP-MICROSERVICE")
public interface ReviewClient {

    @GetMapping("/reviews")
    List<Review> getAllReviews(@RequestParam Integer companyId);
}
