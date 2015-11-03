package com.gmaslowski.sdp.repository;

import com.gmaslowski.sdp.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByName(String lastName);

}
