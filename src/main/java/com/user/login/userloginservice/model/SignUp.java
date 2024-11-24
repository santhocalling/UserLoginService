package com.user.login.userloginservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp{

    private String firstName;
    private String email;
    private String lastName;
    private String userName;
    private String password;


}
