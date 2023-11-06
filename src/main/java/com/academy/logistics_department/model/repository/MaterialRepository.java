package com.academy.logistics_department.model.repository;

import com.academy.logistics_department.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MaterialRepository extends JpaRepository<Item, Integer> {
}
