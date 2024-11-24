package com.user.login.userloginservice.mappers;

import com.user.login.userloginservice.entites.UserEntity;
import com.user.login.userloginservice.model.SignUp;
import com.user.login.userloginservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserDto(UserEntity user);

    @Mapping(target = "password", ignore = true)
    UserEntity signUpToUser(SignUp signUp);

}
