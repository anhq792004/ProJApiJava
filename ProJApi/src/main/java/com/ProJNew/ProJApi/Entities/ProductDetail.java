package com.ProJNew.ProJApi.Entities;

import com.ProJNew.ProJApi.Entities.Enums.Status;
import com.ProJNew.ProJApi.Entities.Properties.Color;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_detail_code", length = 100, unique = true)
    private String productDetailCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(length = 10)
    private String size;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(name = "sole_material", length = 255)
    private String soleMaterial;

    @Column(name = "upper_material", length = 255)
    private String upperMaterial;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status = Status.Active;

}
