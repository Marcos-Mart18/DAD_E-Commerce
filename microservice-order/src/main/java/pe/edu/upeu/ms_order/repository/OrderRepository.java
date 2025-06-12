package pe.edu.upeu.ms_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.ms_order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
