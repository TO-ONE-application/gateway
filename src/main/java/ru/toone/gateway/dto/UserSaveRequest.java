package ru.toone.gateway.dto;


public class UserSaveRequest {
    private String name;
    private String email;
    private String keycloakUserId;

    public UserSaveRequest(String name, String email, String keycloakUserId) {
        this.name = name;
        this.email = email;
        this.keycloakUserId = keycloakUserId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserSaveRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", keycloakId='" + keycloakUserId + '\'' +
                '}';
    }
}
