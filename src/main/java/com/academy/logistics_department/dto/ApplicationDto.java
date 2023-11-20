package com.academy.logistics_department.dto;

import com.academy.logistics_department.model.entity.Address;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.entity.Item;
import com.academy.logistics_department.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private Integer id;
    private List<Item> items;
    private Address loadingAddress;
    private Address unloadingAddress;
    private User customer;
    private ApplicationStatus status;
}
