package com.academy.logistics_department.service;

import com.academy.logistics_department.dto.AddressDto;

public interface AddressService {
    AddressDto createAddress(String city, String street, String building);
}
