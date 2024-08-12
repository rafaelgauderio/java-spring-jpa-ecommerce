package com.rafaeldeluca.ecommerce_spring_jpa.springboot.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name="tb_products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                ),
                @UniqueConstraint(
                        name = "name_unique",
                        columnNames = "name"
                )
        }
)

public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "tb_product_generator")
    @SequenceGenerator(
            name = "name_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 50
    )
    private Long Id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(name = "stock_keeping_unit", nullable = false,length = 20)
    private String sku;

    @Column(scale = 2)
    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    /*
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

     */
}
