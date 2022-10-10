package com.example.blogg.service;

import com.example.blogg.dto.CreatePostDTO;
import com.example.blogg.entities.Post;
import com.example.blogg.repo.PostRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PostService {

    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> findAll(String contains) {

        if(contains.isBlank())
            return postRepo.findAll();

        return postRepo.findPostsByTitleContainsIgnoreCase(contains);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") int id) {
        return postRepo.findById(id).orElseThrow();
    }

    public Post addPost(String title, String description) {
        return postRepo.save(new Post(title, description));
    }
}
