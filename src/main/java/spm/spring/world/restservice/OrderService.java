package spm.spring.world.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spm.spring.world.entities.Order;
import spm.spring.world.entities.User;
import spm.spring.world.exceptions.OrderExistException;
import spm.spring.world.exceptions.OrderNotFoundException;
import spm.spring.world.repository.OrderRepository;
import spm.spring.world.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    // createUser Method
    public Order createOrder(Order order, Long userId) throws OrderExistException {
        Optional<User> user = userRepository.findById(userId);
        order.setUser(user.get());
        Optional<Order> createOrder = orderRepository.findById(order.getOrderId());
        if (createOrder.isPresent()) {
            throw new OrderExistException("Order already exist, please check the user id");
        }
        return orderRepository.save(order);
    }

    // createUser Method
    public Order getOrderByOrderId(Long userId, Long orderId) throws OrderNotFoundException {

        Optional<User> user = userRepository.findById(userId);

        boolean isOrderFound = false;
        Order selectedOrder = null;

        if (user.isPresent()) {
            List<Order> orderList = user.get().getOrders();

            selectedOrder = orderList.stream()
                    .filter(order -> order.getOrderId().toString().equals(orderId.toString()))
                    .findAny()
                    .orElse(null);
        }

        if (selectedOrder == null) {
            throw new OrderNotFoundException("Order Not found");
        }
        return selectedOrder;
    }

}
