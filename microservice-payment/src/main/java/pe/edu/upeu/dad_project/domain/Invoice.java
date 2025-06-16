package pe.edu.upeu.dad_project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="tbl_factura")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String doc;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.ALL)
    @JsonIgnore
    private Payment payment;
}
