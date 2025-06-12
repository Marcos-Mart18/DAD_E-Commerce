package pe.edu.upeu.dad_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.dad_project.domain.Payment;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
