package spm.spring.world.controllers.hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.entities.Order;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.UserNotFoundException;
import spm.spring.world.repository.OrderRepository;
import spm.spring.world.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "hateoas/users")
public class OrderHateOasController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    // get all orders for a user
    @RequestMapping("/{userid}/orders")
    public CollectionModel<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
        Optional<User> ususerOptionaler = userRepository.findById(userid);
        if (!ususerOptionaler.isPresent()) {
            throw new UserNotFoundException("User Not Found");
        }

        List<Order> allOrders = ususerOptionaler.get().getOrders();
        CollectionModel<Order> finalEntityModel = new CollectionModel(allOrders);
        return finalEntityModel;
    }

}
