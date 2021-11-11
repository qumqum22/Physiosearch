package com.rehabilitation.demo.controllers;



import com.rehabilitation.demo.payload.LoginRequest;
import com.rehabilitation.demo.repository.UserAccountRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import com.rehabilitation.demo.repository.UserRightsRepository;
import com.rehabilitation.demo.response.JwtResponse;
import com.rehabilitation.demo.security.jwt.JwtUtils;
import com.rehabilitation.demo.services.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class AuthController {

    AuthenticationManager authenticationManager;
    UserAccountRepository userAccountRepository;
    UserDataRepository userDataRepository;
    UserRightsRepository userRightsRepository;
    PasswordEncoder encoder;
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("Received login request:" + loginRequest.ToString());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }


}