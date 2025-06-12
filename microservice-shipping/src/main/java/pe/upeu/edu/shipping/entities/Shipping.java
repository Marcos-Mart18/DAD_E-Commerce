package pe.upeu.edu.shipping.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShipping;

    private Long orderId;
    private String trackingNumber;
    private String carrier;
    private String shippingMethod;
    private LocalDateTime shippedAt;
    private String status;

    @Embedded
    private ShippingAddress address;

}
