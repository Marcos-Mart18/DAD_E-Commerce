package pe.edu.upeu.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.cart.domain.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
