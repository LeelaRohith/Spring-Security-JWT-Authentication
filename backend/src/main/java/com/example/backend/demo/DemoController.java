package com.example.backend.demo;

import com.example.backend.config.JwtService;
import com.example.backend.user.User;
import com.example.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
@CrossOrigin
public class DemoController {
    private final JwtService jwtService;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<String> sayHello(Authentication authentication){
        Optional<User> user = userRepository.findByEmail(authentication.getName());
        return ResponseEntity.ok(user.get().getFirstname());
    }
}
