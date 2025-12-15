package com.ProJNew.ProJApi.Repositories;

import com.ProJNew.ProJApi.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
