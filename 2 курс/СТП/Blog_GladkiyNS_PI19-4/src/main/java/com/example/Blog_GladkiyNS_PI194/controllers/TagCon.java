package com.example.Blog_GladkiyNS_PI194.controllers;

import com.example.Blog_GladkiyNS_PI194.entities.Tag;
import com.example.Blog_GladkiyNS_PI194.services.TagServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagCon {
    private final TagServ tagServ;

    @Autowired
    public TagCon(TagServ tagServ){
        this.tagServ = tagServ;
    }

    @PostMapping(value = "/api/tags")
    public ResponseEntity<?> create(@RequestBody Tag tag){
        tagServ.create(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/tags")
    public  ResponseEntity<List<Tag>> findAll(){
        final List<Tag> blogList = tagServ.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/tags/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Tag> blog = tagServ.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/tags/{id}")
    public ResponseEntity<?> updateTag(@RequestBody Tag tag, @PathVariable(name = "id")Long id){
        if (tagServ.findById(id).isPresent()) {
            tagServ.updateTag(tag, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/tags/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable(name = "id") Long id){
        if (tagServ.findById(id).isPresent()){
            tagServ.deleteTag(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/tags")
    public void deleteAll(){
        tagServ.deleteAll();
    }
}
