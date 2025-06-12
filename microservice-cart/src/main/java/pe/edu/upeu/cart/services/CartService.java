package pe.edu.upeu.cart.services;

import pe.edu.upeu.cart.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart create(Cart cart);
    Cart update(Cart cart);
    void delete(Long id);
    Optional<Cart> getById(Long id);
    List<Cart> getAll();
}
