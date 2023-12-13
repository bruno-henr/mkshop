package com.mkshop.mkshop.data.infrastructure.controllers.authentication;

import com.mkshop.core.configurations.infra.TokenService;
import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.DTO.AuthenticationDTO;
import com.mkshop.mkshop.data.infrastructure.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public LoginController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseAPI<String>> login(@RequestBody AuthenticationDTO data) {

        try {
            System.out.println("usuario - "+data.username() +" "+ data.password());

            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            System.out.println("usernamePassword "+usernamePassword);
            var auth = this.authenticationManager.authenticate(usernamePassword);
//            System.out.println("auth "+auth);
//
//            var token = tokenService.generateToken((User) auth.getPrincipal());
//            System.out.println("token =>"+token);
            return new ResponseEntity<>(
                    new ResponseAPI<>(null, false, HttpStatus.OK.value(), null),
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
