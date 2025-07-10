package ru.toone.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.toone.gateway.dto.UserRequest;
import ru.toone.gateway.dto.UserResponse;

@FeignClient(name = "user-service", url = "/api/v1/users")
public interface UserServiceClient {

    @PostMapping
    UserResponse createUser(@RequestBody UserRequest userRequest);
}
