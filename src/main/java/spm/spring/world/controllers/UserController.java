package spm.spring.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.entities.User;
import spm.spring.world.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //getAllUsers method
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
