package pe.edu.upeu.dad_project.services;

import pe.edu.upeu.dad_project.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction create(Transaction transaction);
    Transaction update(Transaction transaction);
    void delete(Long id);
    Optional<Transaction> getById(Long id);
    List<Transaction> getAll();
}
