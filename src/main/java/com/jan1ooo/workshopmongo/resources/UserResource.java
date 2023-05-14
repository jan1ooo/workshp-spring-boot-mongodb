package com.jan1ooo.workshopmongo.resources;

import com.jan1ooo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria silva", "maria@gmail.com");
        User alex = new User("2", "alex silva", "alex@gmail.com");

        List<User> list = new ArrayList<>();
        list.add(maria);
        list.add(alex);
        return ResponseEntity.ok().body(list);
    }
}
