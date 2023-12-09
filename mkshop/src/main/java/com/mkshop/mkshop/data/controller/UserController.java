package com.mkshop.mkshop.data.controller;

import com.mkshop.core.response.ResponseAPI;
import com.mkshop.mkshop.data.infrastructure.model.User;
import com.mkshop.mkshop.data.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/user")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<List<User>>> getAllUser() {
//        return new ResponseEntity<>(
//                new ResponseAPI<>(
//                        this.userRepository.findAll(),
//                        false, HttpStatus.OK.value(), null),
//                HttpStatus.OK
//        );
//    }
//
//    @GetMapping("/user/username")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<UserDetails>> getUserByUsername(
//            @RequestParam(value = "username") String username
//    ) {
//        UserDetails user = this.userRepository.findByUsername(username);
//
//        return new ResponseEntity<>(
//                new ResponseAPI<>(user, false, HttpStatus.OK.value(), null),
//                HttpStatus.OK
//        );
//    }
//
//    @GetMapping("/user/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<Optional<User>>> getUserById(@PathVariable String id) {
//        try {
//            Optional<User> user = this.userRepository.findById(id);
//
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(user, false, HttpStatus.OK.value(), null),
//                    HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }



//    @PostMapping("/user/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<ResponseAPI<User>> addUser(@RequestBody @Valid UserRegisterDTO user) {
//        try {
//            System.out.println("teste PASSOU AQUI");
//            if(this.userRepository.findByUsername(user.username()) != null) {
//                return new ResponseEntity<>(
//                        new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), "User with this username already exists."),
//                        HttpStatus.BAD_REQUEST
//                );
//            }
//            String passwordEncrypted = new BCryptPasswordEncoder().encode(user.password());
//            User newUser = new User(
//                user.full_name(),
//                user.username(),
//                passwordEncrypted,
//                user.phone_number(),
//                user.cpf(),
//                user.role()
//            );
//            System.out.println(newUser);
//
//            User userCreated = this.userRepository.save(newUser);
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(userCreated, false, HttpStatus.CREATED.value(), null),
//                    HttpStatus.CREATED
//            );
//        } catch (Exception e) {
//            System.out.println("====>  " + e);
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }

//    @PutMapping("/user/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<User>> putUser2(@PathVariable String id, @RequestBody User user) {
//        try {
//            return this.userRepository.findById(id)
//                    .map(result -> {
//                        result.setUsername(user.getUsername());
//                        result.setFull_name(user.getFull_name());
//                        result.setPhone_number(user.getPhone_number());
//                        result.setPassword(user.getPassword() == null ?
//                                result.getPassword() : new BCryptPasswordEncoder().encode(user.getPassword())
//                        );
//                        result.setAddress(user.getAddress() != null ? user.getAddress() : result.getAddress() );
//
//                        this.userRepository.save(result);
//                        return new ResponseEntity<>(
//                                new ResponseAPI<>(result, false, HttpStatus.OK.value(), null),
//                                HttpStatus.OK
//                        );
//
//                    })
//                    .orElseGet(() -> {
//                        User userCreated = this.userRepository.save(user);
//                        return new ResponseEntity<>(
//                                new ResponseAPI<>(userCreated, false, HttpStatus.CREATED.value(), null),
//                                HttpStatus.CREATED
//                        );
//                    });
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(null, true, HttpStatus.BAD_REQUEST.value(), e.toString()),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }

//    @DeleteMapping("/user/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<ResponseAPI<String>> deleteUser(@PathVariable String id) {
//        try {
//            this.userRepository.deleteById(id);
//            return new ResponseEntity(
//                    new ResponseAPI<String>(
//                            "Usuário removido com sucesso.",
//                            false,
//                            HttpStatus.OK.value(), null),
//                    HttpStatus.OK
//            );
//        } catch (Exception e) {
//            return new ResponseEntity<>(
//                    new ResponseAPI<>(
//                            "Erro ao excluir usuario",
//                            true,
//                            HttpStatus.BAD_REQUEST.value(),
//                            e.toString()
//                    ),
//                    HttpStatus.BAD_REQUEST
//            );
//        }
//    }
}
