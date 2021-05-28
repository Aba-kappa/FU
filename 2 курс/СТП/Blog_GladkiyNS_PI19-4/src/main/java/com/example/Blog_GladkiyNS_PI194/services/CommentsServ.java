package com.example.Blog_GladkiyNS_PI194.services;

import com.example.Blog_GladkiyNS_PI194.entities.Comments;
import com.example.Blog_GladkiyNS_PI194.repositories.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServ {
    @Autowired
    private CommentsRepo commentsRepo;

    public void create(Comments comments){
        commentsRepo.save(comments);
    }

    public List<Comments> findAll(){
        return commentsRepo.findAll();
    }

    public Optional<Comments> findById(Long id){
        return commentsRepo.findById(id);
    }

    public void updateComment(Comments comments, Long id){
        if (findById(id).isPresent()){
            comments.setId(id);
            commentsRepo.save(comments);
        }
    }
    public boolean deleteComment(Long id) {
        if (findById(id).isPresent()) {
            commentsRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        commentsRepo.deleteAll();
    }
}
