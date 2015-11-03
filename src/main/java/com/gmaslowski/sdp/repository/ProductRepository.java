package com.gmaslowski.sdp.repository;

import com.gmaslowski.sdp.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
