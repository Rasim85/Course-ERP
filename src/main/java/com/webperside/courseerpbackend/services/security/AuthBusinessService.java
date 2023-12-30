package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.payload.auth.LoginPayload;
import com.webperside.courseerpbackend.payload.auth.RefreshTokenPayload;
import com.webperside.courseerpbackend.payload.auth.SignUpPayload;
import com.webperside.courseerpbackend.response.auth.LoginResponse;

public interface AuthBusinessService {
    LoginResponse login (LoginPayload payload);
    LoginResponse refresh(RefreshTokenPayload payload);
    void logout();
    void setAuthentication(String email);
    void signUp(SignUpPayload payload);

}
