package com.ironhack.client_service.feignclients;

import com.ironhack.client_service.dtos.ActivityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "activity-service")
public interface ActivityFeignClient {
    @GetMapping("/api/activity/{id}")
    ActivityDTO getActivityById(@PathVariable Long id);
}
