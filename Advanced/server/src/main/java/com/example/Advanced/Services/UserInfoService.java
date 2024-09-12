package com.example.Advanced.Services;

import com.example.Advanced.Models.UserInfo;
import com.example.Advanced.Repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo) {
        // Encode password before saving the user
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        repository.save(userInfo);
        return "User Added Successfully";
    }
}
