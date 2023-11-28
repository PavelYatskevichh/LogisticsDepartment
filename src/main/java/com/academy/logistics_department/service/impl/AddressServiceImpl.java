package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.AddressDto;
import com.academy.logistics_department.mappers.AddressMapper;
import com.academy.logistics_department.model.entity.Address;
import com.academy.logistics_department.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;

    @Override
    public AddressDto createAddress(String city, String street, String building) {
        Address address = Address.builder()
                .city(city)
                .street(street)
                .building(building)
                .build();

        return addressMapper.toDto(address);
    }
}
