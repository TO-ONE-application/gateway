package ru.toone.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.toone.gateway.dto.RegistrationRequest;
import ru.toone.gateway.dto.UserSaveRequest;
import ru.toone.gateway.dto.UserResponse;
import ru.toone.gateway.service.KeycloakAdminClient;
import ru.toone.gateway.service.UserServiceClient;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final KeycloakAdminClient keycloakAdminClient;
    private final UserServiceClient userServiceClient;

    public AuthController(KeycloakAdminClient keycloakAdminClient,
                          UserServiceClient userServiceClient) {
        this.keycloakAdminClient = keycloakAdminClient;
        this.userServiceClient = userServiceClient;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        try {
            String keycloakUserId = keycloakAdminClient.registerUser(
                    request.getName(),
                    request.getPassword(),
                    request.getEmail()
            );
            try {
                UserSaveRequest userSaveRequest = new UserSaveRequest(request.getName(),
                        request.getEmail(),
                        keycloakUserId);
                ResponseEntity<UserResponse> userResponse = userServiceClient.createUser(userSaveRequest);
                return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.PARTIAL_CONTENT);
            }

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}