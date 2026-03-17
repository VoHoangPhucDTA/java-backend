package com.example.javabuilder.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.javabuilder.dto.request.AuthenticationRequest;
import com.example.javabuilder.dto.response.AuthenticationResponse;
import com.example.javabuilder.exception.AppException;
import com.example.javabuilder.exception.ErrorCode;
import com.example.javabuilder.repository.ProductRepository;
import com.example.javabuilder.service.itf.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    ProductRepository productRepository;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var product = productRepository.findByName(request.getName()).orElseThrow(()
         -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), product.getPassword());
        if (!authenticated) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }




    }

    private String generateToken(String name) {
        JWSObject jwsObject = new JWSObject(
                new JWSHeader(JWSAlgorithm.HS256),
                new Payload(name)
        );
        return jwsObject.serialize();

    }

    
}
