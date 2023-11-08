package com.mkshop.mkshop.controller;

import com.mkshop.mkshop.DTO.AuthenticationDTO;
import com.mkshop.mkshop.ResponseAPI;
import com.mkshop.mkshop.infra2.TokenService;
import com.mkshop.mkshop.model.User;
import com.mkshop.mkshop.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity<ResponseAPI<String>> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new ResponseEntity<>(
                new ResponseAPI<>(token, false, HttpStatus.OK.value(), null),
                HttpStatus.OK
        );
    }
}
