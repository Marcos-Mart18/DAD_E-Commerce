package pe.upeu.edu.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upeu.edu.shipping.entities.Shipping;

import java.util.Optional;
@Repository
public interface ShippingRepository  extends JpaRepository<Shipping, Long> {
    Optional<Shipping> findByOrderId(Long orderId);
}
