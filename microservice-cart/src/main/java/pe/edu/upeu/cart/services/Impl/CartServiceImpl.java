package pe.edu.upeu.cart.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cart.domain.Cart;
import pe.edu.upeu.cart.repository.CartRepository;
import pe.edu.upeu.cart.services.CartService;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Long id) {cartRepository.deleteById(id);}

    @Override
    public Optional<Cart> getById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }
}
