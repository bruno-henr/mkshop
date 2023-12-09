package com.mkshop.mkshop.data.mappers;

import com.mkshop.mkshop.data.infrastructure.model.User;
import com.mkshop.mkshop.domain.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity UserModelToUserEntity(User user) {
        return new UserEntity(
                user.getFull_name(),
                user.getUsername(),
                user.getPassword(),
                user.getPhone_number(),
                user.getCpf(),
                user.getAddress(),
                user.getOrder(),
                user.getRole(),
                user.getId());
    }

    public User UserEntityToUserModel(UserEntity userEntity) {
        return new User(
                userEntity.full_name(),
                userEntity.username(),
                userEntity.password(),
                userEntity.phone_number(),
                userEntity.cpf(),
                userEntity.address(),
                userEntity.order(),
                userEntity.role()
        );
    }
}
