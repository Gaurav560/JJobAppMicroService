package com.telusko.Job.client;

import com.telusko.Job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-APP-MICROSERVICE")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
  Company getCompany(@PathVariable Integer id);
}
