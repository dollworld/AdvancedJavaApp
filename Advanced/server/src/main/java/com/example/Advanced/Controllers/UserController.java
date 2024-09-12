package com.example.Advanced.Controllers;

import com.example.Advanced.Models.AuthRequest;
import com.example.Advanced.Models.UserInfo;
import com.example.Advanced.Services.JwtService;
import com.example.Advanced.Services.UserInfoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@Transactional
public class UserController {
    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;



    @GetMapping("/welcome")
    public String getWelcome(){
        return "Welcome Page";
    }

    @PostMapping("/user/add")
    public String postAddNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @GetMapping("/get/user/profile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getUserProfile(){
        return "returning role user profile";
    }

    @GetMapping("/get/admin/profile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdminProfile(){
        return "returning admin role profile";
    }

    @PostMapping("/generateToken")
        public String postGenerateToken (@RequestBody AuthRequest authRequest) throws Exception {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("Invalid user request!");
            }

        }

}
