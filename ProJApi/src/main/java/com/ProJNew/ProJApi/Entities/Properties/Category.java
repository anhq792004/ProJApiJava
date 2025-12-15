package com.ProJNew.ProJApi.Entities.Properties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code", length = 50, unique = true)
    private String categoryCode;

    @Column(name = "category_name", length = 255, nullable = false)
    private String categoryName;

}
