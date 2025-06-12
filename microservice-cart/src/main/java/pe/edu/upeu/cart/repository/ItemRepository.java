package pe.edu.upeu.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.cart.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
