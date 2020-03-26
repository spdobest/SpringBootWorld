package spm.spring.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.UserExistsException;
import spm.spring.world.exceptions.UserNameNotFoundException;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.service.UserService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
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
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder) {
        try {

            userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (UserExistsException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }

    // create user method
    // @PathVariable Annotation
    // @GetMapping Annotation
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    // create user method
    // @PathVariable Annotation
    // @PutMapping Annotation
    @PutMapping("/users/{id}")
    public User updateUserByUserId(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            return userService.updateUserByUserId(id, user);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    // create user method
    // @PathVariable Annotation
    // @DeleteMapping Annotation
    @DeleteMapping("/users/{id}")
    public String deleteUserByUserId(@PathVariable Long id) {
        try {
            return userService.deleteUserByUserId(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // create user method
    // @PathVariable Annotation
    // @DeleteMapping Annotation
    @GetMapping("/users/byusername/{username}")
    public User getUserByUserName(@PathVariable("username") String username) {
        try {
            return userService.getUserByUserName(username);
        } catch (UserNameNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
