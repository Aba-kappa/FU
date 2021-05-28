package com.example.Blog_GladkiyNS_PI194.services;

import com.example.Blog_GladkiyNS_PI194.entities.Tag;
import com.example.Blog_GladkiyNS_PI194.repositories.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServ {
    @Autowired
    private TagRepo tagRepo;

    public void create(Tag tag){
        tagRepo.save(tag);
    }

    public List<Tag> findAll(){
        return tagRepo.findAll();
    }

    public Optional<Tag> findById(Long id){
        return tagRepo.findById(id);
    }

    public void updateTag(Tag tag, Long id){
        if (findById(id).isPresent()){
            tag.setId(id);
            tagRepo.save(tag);
        }
    }

    public boolean deleteTag(Long id) {
        if (findById(id).isPresent()) {
            tagRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        tagRepo.deleteAll();
    }
}
