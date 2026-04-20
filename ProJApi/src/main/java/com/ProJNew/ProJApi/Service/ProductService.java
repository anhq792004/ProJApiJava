package com.ProJNew.ProJApi.Service;

import com.ProJNew.ProJApi.Dto.Request.ProductCreateRequest;
import com.ProJNew.ProJApi.Dto.Request.ProductUpdateRequest;
import com.ProJNew.ProJApi.Dto.Response.ProductResponse;
import com.ProJNew.ProJApi.Entities.Enums.Status;
import com.ProJNew.ProJApi.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductResponse> getAll(Status status, Pageable pageable);

    ProductResponse create(ProductCreateRequest request);

    ProductResponse update(Long id, ProductUpdateRequest request);

    Product getEntityById(Long id);
}
