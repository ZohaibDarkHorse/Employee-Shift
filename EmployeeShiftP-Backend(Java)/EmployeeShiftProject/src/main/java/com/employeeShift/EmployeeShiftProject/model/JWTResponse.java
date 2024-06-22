package com.employeeShift.EmployeeShiftProject.model;

public class JWTResponse {

    private String jwtToken;
    private String username;

    // Private constructor for Builder pattern
    private JWTResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    // Getters and setters
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Builder class for JWTResponse
    public static class JWTResponseBuilder {
        private String jwtToken;
        private String username;

        public JWTResponseBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JWTResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public JWTResponse build() {
            return new JWTResponse(jwtToken, username);
        }
    }

    // Static method to get a builder instance
    public static JWTResponseBuilder builder() {
        return new JWTResponseBuilder();
    }

    @Override
    public String toString() {
        return "JWTResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
    }
}
