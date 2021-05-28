package com.example.Blog_GladkiyNS_PI194.repositories;

import com.example.Blog_GladkiyNS_PI194.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments, Long> {
}
