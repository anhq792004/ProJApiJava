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
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_code", length = 50, unique = true)
    private String brandCode;

    @Column(name = "brand_name", length = 255, nullable = false)
    private String brandName;

}
