package com.ProJNew.ProJApi.Entities;

import com.ProJNew.ProJApi.Entities.Enums.Gender;
import com.ProJNew.ProJApi.Entities.Enums.Status;
import com.ProJNew.ProJApi.Entities.Properties.Brand;
import com.ProJNew.ProJApi.Entities.Properties.Category;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_code", length = 100, unique = true)
    private String productCode;

    @Column(name = "product_name", length = 255, nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "material_id")
    private Long materialId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Column(length = 255)
    private String trademark;

    @Column(name = "origin_country", length = 100)
    private String originCountry;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status = Status.Active;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
