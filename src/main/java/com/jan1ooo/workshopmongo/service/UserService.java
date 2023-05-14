package com.jan1ooo.workshopmongo.service;

import com.jan1ooo.workshopmongo.domain.User;
import com.jan1ooo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
