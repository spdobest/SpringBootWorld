package spm.spring.world.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.model.ResponseModel;
import spm.spring.world.model.user.User;
import spm.spring.world.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    // Get all students from the h2 database.
    // @GetMapping annotation handles the http get request matched with the given uri.
    @GetMapping(value = "/user/allUser", produces = "application/vnd.jcg.api.v1+json")
    public ResponseModel<List<User>> getAll() {
        return userService.getAll();
    }
}
