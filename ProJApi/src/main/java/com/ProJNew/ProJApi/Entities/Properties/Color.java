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
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color_code", length = 50, unique = true)
    private String colorCode;

    @Column(name = "color_name", length = 100, nullable = false)
    private String colorName;

}
