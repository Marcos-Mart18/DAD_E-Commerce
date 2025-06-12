package pe.edu.upeu.dad_project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "tbl_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "Monto")
    private double monto;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Fecha")
    private String fecha;

    private String errorMessage;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "method_id", nullable = false)
    private Method method;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;
}
