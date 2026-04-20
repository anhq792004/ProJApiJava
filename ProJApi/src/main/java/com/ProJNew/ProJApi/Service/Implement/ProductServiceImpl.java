package com.ProJNew.ProJApi.Service.Implement;

import com.ProJNew.ProJApi.Dto.Request.ProductCreateRequest;
import com.ProJNew.ProJApi.Dto.Request.ProductUpdateRequest;
import com.ProJNew.ProJApi.Dto.Response.ProductResponse;
import com.ProJNew.ProJApi.Entities.Enums.Status;
import com.ProJNew.ProJApi.Entities.Product;
import com.ProJNew.ProJApi.Mapper.ProductMapper;
import com.ProJNew.ProJApi.Repositories.ProductRepository;
import com.ProJNew.ProJApi.Service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getAll(Status status, Pageable pageable) {
        Page<Product> page;

        if (status != null) {
            page = productRepository.findAllByStatus(status, pageable);
        } else {
            page = productRepository.findAll(pageable);
        }

        return page.map(productMapper::toResponse);
    }

    @Override
    public ProductResponse create(ProductCreateRequest request) {
        if (productRepository.existsByProductCode(request.getProductCode())) {
            throw new IllegalArgumentException("Product code already exists");
        }
        Product product = productMapper.toEntity(request);
        product.setStatus(request.getStatus() != null ? request.getStatus() : Status.Active);
        Product savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse update(Long id, ProductUpdateRequest request) {
        Product product = getEntityById(id);
        productMapper.updateEntity(request, product);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public Product getEntityById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}
