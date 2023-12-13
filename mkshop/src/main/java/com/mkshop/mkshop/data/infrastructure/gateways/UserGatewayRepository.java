package com.mkshop.mkshop.data.infrastructure.gateways;

import com.mkshop.mkshop.data.application.gateways.UserGateway;
import com.mkshop.mkshop.data.infrastructure.persistence.UserRepository;
import com.mkshop.mkshop.data.mappers.UserMapper;
import com.mkshop.mkshop.data.infrastructure.model.User;
import com.mkshop.mkshop.domain.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserGatewayRepository implements UserGateway {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserGatewayRepository(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        User userModel = this.userMapper.UserEntityToUserModel(user);
        userModel.setPassword(
                new BCryptPasswordEncoder().encode(userModel.getPassword())
        );
        User userSaved = this.userRepository.save(userModel);

        return this.userMapper.UserModelToUserEntity(userSaved);
    }

    @Override
    public UserEntity editUser(String id, UserEntity user) {
        return this.userRepository.findById(id)
                .map(result -> {
                    result.setUsername(user.username() == null ? result.getUsername() : user.username());
                    result.setFull_name(user.full_name() == null ? result.getFull_name() : user.full_name());
                    result.setPhone_number(user.phone_number() == null ? result.getPhone_number() : user.phone_number());
                    result.setCpf(user.cpf() == null ? result.getCpf() : user.cpf());
                    result.setPassword(user.password() == null ?
                            result.getPassword() : new BCryptPasswordEncoder().encode(user.password())
                    );
                    result.setAddress(user.address() != null ? user.address() : result.getAddress());

                    User userUpdated = this.userRepository.save(result);
                    return this.userMapper.UserModelToUserEntity(userUpdated);
                })
                .orElseGet(() -> {
                    User userModel = this.userMapper.UserEntityToUserModel(user);
                    User userCreated = this.userRepository.save(userModel);

                    return this.userMapper.UserModelToUserEntity(userCreated);
                });

    }

    @Override
    public String deleteUser(String id) {
        this.userRepository.deleteById(id);
        return "Usuário removido com sucesso.";
    }

    @Override
    public List<UserEntity> getAllUser() {
        return this.userRepository.findAll().stream().map(user -> this.userMapper.UserModelToUserEntity(user)).toList();
    }

    @Override
    public Optional<UserEntity> getUserById(String id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.map(value -> this.userMapper.UserModelToUserEntity(value));
    }

    @Override
    public UserDetails getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
