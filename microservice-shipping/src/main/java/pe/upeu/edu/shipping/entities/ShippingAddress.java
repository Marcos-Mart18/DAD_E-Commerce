package pe.upeu.edu.shipping.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private String street;
}
