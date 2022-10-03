package com.example.blogg;

import com.example.blogg.entities.Post;
import com.example.blogg.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BloggApplication implements CommandLineRunner {

    @Autowired
    PostRepo postRepo;

    public static void main(String[] args) {
        SpringApplication.run(BloggApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        postRepo.saveAll(List.of(
                new Post("Första blogginlägget", "- Skribenter sökes.")
        ));
    }

}
