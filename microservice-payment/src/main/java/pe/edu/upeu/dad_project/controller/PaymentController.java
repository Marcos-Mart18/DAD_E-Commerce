package pe.edu.upeu.dad_project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.dad_project.domain.Payment;
import pe.edu.upeu.dad_project.dto.PaymentDTO;
import pe.edu.upeu.dad_project.dto.PaymentMapper;
import pe.edu.upeu.dad_project.services.Impl.PaymentServiceImpl;
import pe.edu.upeu.dad_project.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        try {
            List<Payment> p = paymentService.getAll();
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") Long id) {
        try {
            Payment p = paymentService.getById(id).get();
            if (p == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Payment> create(@Validated @RequestBody Payment payment) {
        try {
            Payment p = paymentService.create(payment);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Payment payment) {
        Payment p = paymentService.getById(id).get();
        if (p.getId() > 0) {
            return new ResponseEntity<>(paymentService.update(payment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> delete(@PathVariable("id") Long id) {
        try {
            paymentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin")
    public ResponseEntity<List<PaymentDTO>> getAllForAdmin() {
        try {
            List<Payment> payments = paymentService.getAll();
            if (payments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            List<PaymentDTO> dtoList = payments.stream()
                    .map(PaymentMapper::toDto)
                    .toList();

            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<PaymentDTO> getByIdForAdmin(@PathVariable("id") Long id) {
        try {
            Payment payment = paymentService.getById(id).orElse(null);
            if (payment == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            PaymentDTO dto = PaymentMapper.toDto(payment);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
