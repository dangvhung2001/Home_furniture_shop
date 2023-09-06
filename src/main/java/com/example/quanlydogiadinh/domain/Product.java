package com.example.quanlydogiadinh.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "img_url", length = 255)
    private String product_ImgUrl;
    private String name;
    private String productCode;
    private int quantity;
    private String description;
    private float price;
    private String status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_catalog",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "catalog_id")})
    private Set<Catalog> catalogs = new HashSet<>();
}
