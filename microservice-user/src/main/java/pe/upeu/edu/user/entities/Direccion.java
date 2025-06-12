package pe.upeu.edu.user.entities;

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
@Table(name = "tbl_direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre_completo", columnDefinition = "varchar(60)", nullable = false)
    private String nombrecompleto;
    @Column(name = "departamento", columnDefinition = "varchar(50)", nullable = false)
    private String departamento;
    @Column(name = "provincia", columnDefinition = "varchar(50)", nullable = false)
    private String provincia;
    @Column(name = "distrito", columnDefinition = "varchar(50)", nullable = false)
    private String distrito;
    @Column(name = "tipo_calle", columnDefinition = "varchar(25)", nullable = false)
    private String tipo_calle;
    @Column(name = "calle", columnDefinition = "varchar(100)", nullable = false)
    private String calle;
    @Column(name = "numero", columnDefinition = "integer", nullable = false)
    private int numero;
    @Column(name = "piso_departamento", columnDefinition = "varchar(12)", nullable = true)
    private String piso_departamento;
    @Column(name = "home_work", columnDefinition = "varchar(10)")
    private String home_work;
    @Column(name = "contacto", columnDefinition = "varchar(20)", nullable = false)
    private String contacto;
    @Column(name = "referencia", columnDefinition = "varchar(120)", nullable = false)
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;


}
