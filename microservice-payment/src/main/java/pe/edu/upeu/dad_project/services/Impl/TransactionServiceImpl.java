package pe.edu.upeu.dad_project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dad_project.domain.Payment;
import pe.edu.upeu.dad_project.domain.Transaction;
import pe.edu.upeu.dad_project.repository.PaymentRepository;
import pe.edu.upeu.dad_project.repository.TransactionRepository;
import pe.edu.upeu.dad_project.services.PaymentService;
import pe.edu.upeu.dad_project.services.TransactionService;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Optional<Transaction> getById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
    }
