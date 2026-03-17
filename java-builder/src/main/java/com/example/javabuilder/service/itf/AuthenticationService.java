package com.example.javabuilder.service.itf;

import com.example.javabuilder.dto.request.AuthenticationRequest;
import com.example.javabuilder.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
