package com.skillsync.skillsync_backend.security;

import com.skillsync.skillsync_backend.dto.AuthRequest;
import com.skillsync.skillsync_backend.dto.AuthResponse;
import com.skillsync.skillsync_backend.model.User;
import com.skillsync.skillsync_backend.service.UserService;
import com.skillsync.skillsync_backend.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;
    @Autowired private UserService userService;

   @PostMapping("/register")
public ResponseEntity<AuthResponse> register(@RequestBody User user) {

    if (userService.findByEmail(user.getEmail()).isPresent()) {
        // 409 Conflict if email exists
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new AuthResponse("Email already in use"));
    }

    User saved = userService.createUser(user);          // hashes pwd
    String jwt  = jwtService.generateToken(saved.getEmail());

    // 201 Created with JSON body
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(new AuthResponse(jwt));
}


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword());
            authManager.authenticate(authToken);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).build();
        }
        String token = jwtService.generateToken(request.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

