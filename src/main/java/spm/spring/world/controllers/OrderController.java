package spm.spring.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import spm.spring.world.entities.Order;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.OrderExistException;
import spm.spring.world.exceptions.OrderNotFoundException;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.repository.UserRepository;
import spm.spring.world.restservice.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    // get all orders for a user
    @RequestMapping("/{userid}/orders")
    private List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userid);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User Not Found");
        }
        return user.get().getOrders();
    }

    @PostMapping("/{userId}/orders")
    private ResponseEntity<Void> createOrder(@PathVariable(value = "userId") Long userId, @RequestBody Order order, UriComponentsBuilder builder) {
        try {
            orderService.createOrder(order, userId);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{userid}/orders").buildAndExpand(order.getUser().getUserId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (OrderExistException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @RequestMapping("/{userId}/orders/{orderId}")
    private Order getOrderByOrderId(@PathVariable(value = "userId") Long userId, @PathVariable(value = "orderId") Long orderId) {
        try {
            return orderService.getOrderByOrderId(userId, orderId);
        } catch (OrderNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

}
