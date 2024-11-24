package com.user.login.userloginservice.contoller;


import com.user.login.userloginservice.config.UserAuthenticationProvider;
import com.user.login.userloginservice.model.Credentials;
import com.user.login.userloginservice.model.SignUp;
import com.user.login.userloginservice.model.User;
import com.user.login.userloginservice.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/signin")
    public ResponseEntity<User> login(@RequestBody @Valid Credentials credentials) {
        User user = userService.login(credentials);
        user.setToken(userAuthenticationProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody @Valid SignUp user) {
        User createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @GetMapping("/retrieveCustomer")
    public ResponseEntity<User> register(@RequestParam("username") String username) {
        User retrivedUser = userService.findByUserName(username);
        return ResponseEntity.ok(retrivedUser);
    }





}
