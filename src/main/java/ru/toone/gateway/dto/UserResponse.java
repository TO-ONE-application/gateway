package ru.toone.gateway.dto;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String keycloakUserId;


    public String getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", keycloakUserId='" + keycloakUserId + '\'' +
                '}';
    }

    public UserResponse(Long id, String name, String email, String keycloakUserId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.keycloakUserId = keycloakUserId;
    }
}
