package com.example.Blog_GladkiyNS_PI194.controllers;

import com.example.Blog_GladkiyNS_PI194.entities.Comments;
import com.example.Blog_GladkiyNS_PI194.services.CommentsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentsCon {
    private final CommentsServ commentsServ;

    @Autowired
    public CommentsCon(CommentsServ commentsServ){
        this.commentsServ = commentsServ;
    }

    @PostMapping(value = "/api/comments")
    public ResponseEntity<?> create(@RequestBody Comments comment){
        commentsServ.create(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/comments")
    public  ResponseEntity<List<Comments>> findAll(){
        final List<Comments> blogList = commentsServ.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/comments/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Comments> blog = commentsServ.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/comments/{id}")
    public ResponseEntity<?> updateComment(@RequestBody Comments comment, @PathVariable(name = "id")Long id){
        if (commentsServ.findById(id).isPresent()) {
            commentsServ.updateComment(comment, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "id") Long id){
        if (commentsServ.findById(id).isPresent()){
            commentsServ.deleteComment(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/comments")
    public void deleteAll(){
        commentsServ.deleteAll();
    }
}
