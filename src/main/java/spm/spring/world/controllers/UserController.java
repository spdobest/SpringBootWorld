package spm.spring.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spm.spring.world.entities.User;
import spm.spring.world.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //getAllUsers method
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // create user method
    // @RequestBody Annotation
    // @PostMapping Annotation
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // create user method
    // @PathVariable Annotation
    // @GetMapping Annotation
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // create user method
    // @PathVariable Annotation
    // @PutMapping Annotation
    @PutMapping("/users/{id}")
    public User updateUserByUserId(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUserByUserId(id, user);
    }

    // create user method
    // @PathVariable Annotation
    // @DeleteMapping Annotation
    @DeleteMapping("/users/{id}")
    public String deleteUserByUserId(@PathVariable Long id) {
        return userService.deleteUserByUserId(id);
    }
}
