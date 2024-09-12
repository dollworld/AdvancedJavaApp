# AdvancedJavaApp
# SpringBoot 3.0 Java Features

Test App on postman with the following inputs:
-- Add new user
        "name":"user1",
        "username": "user1",
        "password": "password1",
        "email": "user1@hotmail.com",
        "roles": "ROLE_USER"

        -- GenerateToken
         "username": "user1",
         "password": "password1",

         --Add Bearer token (returned from above generated token) to get User profile
         to test on postman
