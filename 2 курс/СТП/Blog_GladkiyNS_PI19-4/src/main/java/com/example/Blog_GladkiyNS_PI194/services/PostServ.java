package com.example.Blog_GladkiyNS_PI194.services;

import com.example.Blog_GladkiyNS_PI194.entities.Post;
import com.example.Blog_GladkiyNS_PI194.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServ {
    @Autowired
    private PostRepo postRepo;

    public void create(Post post){
        postRepo.save(post);
    }

    public List<Post> findAll(){
        return postRepo.findAll();
    }

    public Optional<Post> findById(Long id){
        return postRepo.findById(id);
    }

    public void updatePost(Post post, Long id){
        if (findById(id).isPresent()){
            post.setId(id);
            postRepo.save(post);
        }
    }
    public boolean deletePost(Long id) {
        if (findById(id).isPresent()) {
            postRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        postRepo.deleteAll();
    }
}
