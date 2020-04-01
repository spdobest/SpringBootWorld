package spm.spring.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spm.spring.client.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(Long username);
}
