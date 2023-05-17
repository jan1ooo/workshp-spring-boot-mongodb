package com.jan1ooo.workshopmongo.service;

import com.jan1ooo.workshopmongo.domain.Post;
import com.jan1ooo.workshopmongo.domain.User;
import com.jan1ooo.workshopmongo.dto.UserDTO;
import com.jan1ooo.workshopmongo.repository.PostRepository;
import com.jan1ooo.workshopmongo.repository.UserRepository;
import com.jan1ooo.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
