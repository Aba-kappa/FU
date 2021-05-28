package com.example.Blog_GladkiyNS_PI194.controllers;

import com.example.Blog_GladkiyNS_PI194.entities.Post;
import com.example.Blog_GladkiyNS_PI194.services.PostServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostCon {

    private final PostServ postServ;

    @Autowired
    public PostCon(PostServ postServ){
        this.postServ = postServ;
    }

    @PostMapping(value = "/api/posts")
    public ResponseEntity<?> create(@RequestBody Post post){
        postServ.create(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/posts")
    public  ResponseEntity<List<Post>> findAll(){
        final List<Post> blogList = postServ.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/posts/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Post> blog = postServ.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/posts/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable(name = "id")Long id){
        if (postServ.findById(id).isPresent()) {
            postServ.updatePost(post, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id){
        if (postServ.findById(id).isPresent()){
            postServ.deletePost(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/posts")
    public void deleteAll(){
        postServ.deleteAll();
    }
}
