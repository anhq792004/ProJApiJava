package com.ProJNew.ProJApi.Repositories;

import com.ProJNew.ProJApi.Entities.Enums.Status;
import com.ProJNew.ProJApi.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByStatus(Status status, Pageable pageable);

    boolean existsByProductCode(String productCode);
}
