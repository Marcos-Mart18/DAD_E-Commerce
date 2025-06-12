package pe.edu.upeu.cart.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cart.domain.Item;
import pe.edu.upeu.cart.repository.ItemRepository;
import pe.edu.upeu.cart.services.ItemService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    public ItemRepository itemRepository;

    @Override
    public Item create(Item item) {return itemRepository.save(item);}

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void delete(Long id) {itemRepository.deleteById(id);}

    @Override
    public Optional<Item> getById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
