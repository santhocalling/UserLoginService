package com.user.login.userloginservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String token;

}
