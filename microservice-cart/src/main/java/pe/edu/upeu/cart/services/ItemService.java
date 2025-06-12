package pe.edu.upeu.cart.services;

import pe.edu.upeu.cart.domain.Discount;
import pe.edu.upeu.cart.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item create(Item item);
    Item update(Item item);
    void delete(Long item);
    Optional<Item> getById(Long id);
    List<Item> getAll();
}
