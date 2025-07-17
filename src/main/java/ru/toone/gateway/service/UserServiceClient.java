package ru.toone.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.toone.gateway.dto.UserSaveRequest;
import ru.toone.gateway.dto.UserResponse;

@FeignClient(name = "user-service", url = "http://localhost:1010/api/v1/user")
public interface UserServiceClient {

    @PostMapping
    ResponseEntity<UserResponse> createUser(@RequestBody UserSaveRequest request);
}
