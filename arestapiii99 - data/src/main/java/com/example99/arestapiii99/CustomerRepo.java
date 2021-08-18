package com.example99.arestapiii99;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example99.arestapiii99.entity.Customer;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Long>{

}
