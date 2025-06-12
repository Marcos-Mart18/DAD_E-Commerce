package pe.edu.upeu.ms_order.service;

import pe.edu.upeu.ms_order.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order order);
    void delete(Long id);
}
