package com.example.springboot.controllers;

import com.example.springboot.configs.TokenService;
import com.example.springboot.domain.response.LoginResponseDto;
import com.example.springboot.domain.user.AuthRecordDto;
import com.example.springboot.domain.user.RegisterRecordDto;
import com.example.springboot.domain.user.User;
import com.example.springboot.repositories.UserRepository;
import com.example.springboot.services.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthRecordDto authDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRecordDto registerDto) {
        if (userRepository.findByLogin(registerDto.login()) != null) {
            return ResponseEntity.badRequest().body("Usuário inválido");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        User newUser = new User(registerDto.login(), encryptedPassword, registerDto.role());

        userRepository.save(newUser);

        return ResponseEntity.ok().build();

    }
}
