package com.user.login.userloginservice.services;

import com.user.login.userloginservice.entites.UserEntity;
import com.user.login.userloginservice.exceptions.AppException;
import com.user.login.userloginservice.mappers.UserMapper;
import com.user.login.userloginservice.model.Credentials;
import com.user.login.userloginservice.model.SignUp;
import com.user.login.userloginservice.model.User;
import com.user.login.userloginservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public User login(Credentials credentials) {
        UserEntity user = userRepository.findByUserName(credentials.getUserName())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentials.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public User register(SignUp signUp) {
        Optional<UserEntity> optionalUser = userRepository.findByUserName(signUp.getUserName());

        if (optionalUser.isPresent()) {
            throw new AppException("User already exists", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = userMapper.signUpToUser(signUp);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUp.getPassword())));

        UserEntity savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public User findByUserName(String login) {
        UserEntity user = userRepository.findByUserName(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

}
