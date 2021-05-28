package com.example.Blog_GladkiyNS_PI194.repositories;

import com.example.Blog_GladkiyNS_PI194.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
