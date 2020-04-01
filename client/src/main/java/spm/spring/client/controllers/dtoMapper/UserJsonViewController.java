package spm.spring.client.controllers.dtoMapper;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import spm.spring.client.entities.Order;
import spm.spring.client.entities.User;
import spm.spring.client.entities.Views;
import spm.spring.client.exceptions.UserNotFoundException;
import spm.spring.client.restservice.UserService;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/jsonview/users")
public class UserJsonViewController {

    @Autowired
    private UserService userService;

    // getUserById - external
    @JsonView(Views.External.class)
    @GetMapping("/external/{id}")
    public Optional<User> getUserById(@PathVariable @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // getUserById - internal
    @JsonView(Views.Internal.class)
    @GetMapping("/internal/{id}")
    public Optional<User> getUserById2(@PathVariable @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
