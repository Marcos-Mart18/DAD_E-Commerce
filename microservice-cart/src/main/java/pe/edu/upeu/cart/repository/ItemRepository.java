package pe.edu.upeu.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.cart.domain.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
