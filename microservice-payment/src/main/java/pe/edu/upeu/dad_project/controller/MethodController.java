package pe.edu.upeu.dad_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.dad_project.domain.Method;
import pe.edu.upeu.dad_project.domain.Payment;
import pe.edu.upeu.dad_project.services.MethodService;
import pe.edu.upeu.dad_project.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/method")
public class MethodController {
    @Autowired
    private MethodService methodService;

    @GetMapping
    public ResponseEntity<List<Method>> getAll() {
        try {
            List<Method> p = methodService.getAll();
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Method> getById(@PathVariable("id") Long id) {
        try {
            Method p = methodService.getById(id).get();
            return new ResponseEntity<>(p, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Method> create(@Validated @RequestBody Method method) {
        try {
            Method p = methodService.create(method);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Validated @RequestBody Method method) {
        Method p = methodService.getById(id).get();
        if (p.getId() > 0) {
            return new ResponseEntity<>(methodService.update(method), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Method> delete(@PathVariable("id") Long id) {
        try {
            methodService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
