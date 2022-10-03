package com.example.blogg.service;

import com.example.blogg.entities.Post;
import com.example.blogg.repo.PostRepo;
import org.springframework.stereotype.Service;

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

    public Post findById(int id) {
        return postRepo.findById(id).orElseThrow();
    }
}
