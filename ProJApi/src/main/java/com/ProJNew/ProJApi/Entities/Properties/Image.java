package com.ProJNew.ProJApi.Entities.Properties;

import com.ProJNew.ProJApi.Entities.ProductDetail;
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
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_detail_id", nullable = false)
    private ProductDetail productDetail;

    @Column(name = "image_url", length = 500, nullable = false)
    private String imageUrl;

    @Column(name = "sort_order")
    private Integer sortOrder = 1;

    @Column(name = "is_main")
    private Boolean isMain = false;

}
