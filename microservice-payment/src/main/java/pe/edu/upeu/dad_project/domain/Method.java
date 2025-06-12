package pe.edu.upeu.dad_project.domain;

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
@Table(name = "tbl_method")
public class Method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private Long id;

    @Column (name = "tipo")
    private String tipo;

    @Column(name= "dates_method")
    private String dates_method;

    @OneToMany(mappedBy = "method", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Payment> payment;
}
