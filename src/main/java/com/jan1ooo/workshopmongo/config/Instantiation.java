package com.jan1ooo.workshopmongo.config;

import com.jan1ooo.workshopmongo.domain.Post;
import com.jan1ooo.workshopmongo.domain.User;
import com.jan1ooo.workshopmongo.dto.AuthorDto;
import com.jan1ooo.workshopmongo.repository.PostRepository;
import com.jan1ooo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.logging.SimpleFormatter;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post pos1 = new Post(null, sdf.parse("21/02/2023"), "Pariu SP", "To indo pra SP agora", new AuthorDto(maria));
        Post pos2 = new Post(null, sdf.parse("22/02/2023"), "Bom dia", "Bom dia, tenham um otimo dia", new AuthorDto(maria));
        postRepository.saveAll(Arrays.asList(pos1, pos2));

        maria.getPosts().addAll(Arrays.asList(pos1, pos2));
        userRepository.save(maria);

    }
}
