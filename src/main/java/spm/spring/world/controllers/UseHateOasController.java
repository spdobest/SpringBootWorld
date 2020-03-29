package spm.spring.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import spm.spring.world.entities.Order;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.repository.UserRepository;
import spm.spring.world.service.UserService;

import java.util.List;
import java.util.Optional;

// https://stackoverflow.com/questions/25352764/hateoas-methods-not-found

@RestController
@RequestMapping(value = "hateoas/users")
@Validated
public class UseHateOasController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //getAllUsers method
    @GetMapping
    public CollectionModel<User> getAllUsers() {
        List<User> listUser = userRepository.findAll();
        listUser.forEach(user -> {
            Long userId = user.getUserId();
            Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
            user.add(selfLink);

            // Relationship link with getALlOrders
            try {
                CollectionModel<Order> orders = ControllerLinkBuilder.methodOn(OrderHateOasController.class).getAllOrders(userId);
                Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
                user.add(ordersLink);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        });
        Link selfLinkgetAllUsers = ControllerLinkBuilder.linkTo(this.getClass()).withSelfRel();
        CollectionModel<User> finalEntityModel = new CollectionModel(listUser, selfLinkgetAllUsers);
        return finalEntityModel;
    }

    // create user method
    // @PathVariable Annotation
    // @GetMapping Annotation
    @GetMapping("/{id}")
    public EntityModel<User> getUserById(@PathVariable Long id) {

        Optional<User> userOption = null;
        try {
            userOption = userService.getUserById(id);
            User user = userOption.get();
            Long userId = user.getUserId();
            Link selfLink = ControllerLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
            user.add(selfLink);
            EntityModel<User> finalEntityModel = new EntityModel<>(user);
            return finalEntityModel;
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
