package pe.edu.upeu.dad_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.dad_project.domain.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
