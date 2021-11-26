package com.rehabilitation.demo.response;

import com.rehabilitation.demo.models.UserData;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private Long userdataId;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String email, Long userdataId, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.userdataId = userdataId;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
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

    public Long getUserdataId() {
        return userdataId;
    }

    public void setUserdataId(Long userdataId) {
        this.userdataId = userdataId;
    }

    public List<String> getRoles() {
        return roles;
    }
}
