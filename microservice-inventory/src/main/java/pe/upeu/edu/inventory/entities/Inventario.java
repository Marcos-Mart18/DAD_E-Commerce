package pe.upeu.edu.inventory.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tbl_inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Integer stockDisponible;
    private Integer stockReservado;
    private Integer stockMinimo;
    private String ubicacion;
    private LocalDateTime fechaActualizacion;
    private String estado;

    private Long idProducto;

    @JsonIgnore
    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private List<Movimiento> movimientos;
}
