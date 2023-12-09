package com.mkshop.mkshop.data.controller;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.DTO.AuthenticationDTO;
import com.mkshop.mkshop.data.DTO.ValidTokenDTO;
import com.mkshop.core.configurations.infra.TokenService;
import com.mkshop.mkshop.data.infrastructure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/validarToken")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> validarToken(@RequestBody ValidTokenDTO token) {
        try {
            System.out.println("token "+token);
            String tokenValited = this.tokenService.validateToken(token.token());
            System.out.println("token verificado => "+tokenValited);
            if(!Objects.equals(tokenValited, "")) {
                return new ResponseEntity<>(
                        new ResponseAPI<>(tokenValited, false, HttpStatus.OK.value(), null),
                        HttpStatus.OK
                );

            }
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), "token invalido"),
                    HttpStatus.BAD_REQUEST
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), "token invalido"),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> login(@RequestBody  AuthenticationDTO data) {

        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());
            System.out.println("token =>"+token);
            return new ResponseEntity<>(
                    new ResponseAPI<>(token, false, HttpStatus.OK.value(), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            System.out.println("erro => "+e);
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
                    HttpStatus.BAD_REQUEST
            );
        }

    }
}
