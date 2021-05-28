package com.example.Blog_GladkiyNS_PI194.services;

import com.example.Blog_GladkiyNS_PI194.entities.User;
import com.example.Blog_GladkiyNS_PI194.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServ {
    @Autowired
    private UserRepo userRepo;

    public void create(User user){
        userRepo.save(user);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    public void updateUser(User user, Long id){
        if (findById(id).isPresent()){
            user.setId(id);
            userRepo.save(user);
        }
    }

    public boolean deleteUser(Long id) {
        if (findById(id).isPresent()) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }
}
