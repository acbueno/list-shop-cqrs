package br.com.acbueno.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", length = 255, nullable = false)
    private String brandName;

    @Column(name = "description", length = 255, nullable = false)
    private String description;


    @Column(name = "amount", length = 5, nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "purchase_id" , referencedColumnName = "id", nullable = false)
    private Purchase purchase;

    @Column(name = "price", nullable = false, length = 10)
    private double price;

    @Column(name = "total_price", nullable = false, length = 10)
    private double totalPrice;

}
