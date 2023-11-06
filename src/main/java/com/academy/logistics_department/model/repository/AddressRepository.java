package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
