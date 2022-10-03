package com.example.blogg.repo;

import com.example.blogg.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findPostsByTitleContainsIgnoreCase(String contains);

}
