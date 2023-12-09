package com.mkshop.mkshop.data.infrastructure.controllers.authentication;

import com.mkshop.core.configurations.infra.TokenService;
import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.DTO.ValidTokenDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthenticationTokenController {
    private final TokenService tokenService;

    public AuthenticationTokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

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
}
