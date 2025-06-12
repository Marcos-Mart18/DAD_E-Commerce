package pe.edu.upeu.cart.domain;


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
@Table(name = "tbl_cart")
public class Cart {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String status;
        private double subtotal;
        private double discount;
        private double total;

        @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private List<Item> items;

        @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private List<Discount> discounts;
}
