## UserLoginService

overview of the UserLoginService backend application, developed using Spring Boot:

## <u> Core Features with API: </u>

## User Signup:     /api/auth/signup 
Enables users to register and create an account.
## User Login:    /api/auth/signin
Authenticates users to allow secure access to the application.
## Retrieve Customer Information:  /api/auth/retrieveCustomer
Provides functionality to fetch and manage customer details.

## Security Implementation:

Integrated with Spring Security to ensure robust protection of sensitive user data.
JWT Filter is utilized for token-based authentication, enhancing security and enabling stateless sessions.


# Requirements:
   
    - Jdk 17 
    - Gradle
    - Mysql

## Mysql:
   
   - Create the Database names it as UserDetails
   - Create the table using below schema:

CREATE TABLE `app_user` (
`id` bigint NOT NULL AUTO_INCREMENT,
`email` varchar(255) NOT NULL,
`first_name` varchar(255) NOT NULL,
`last_name` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`user_name` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


## Follow the below steps to run the application

   - Checkout the code from git
   - Run the gradle clean build to clean  the directory and build the application
   - Run the gradle bootRun to run the application 



   
      

     