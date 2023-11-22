package com.academy.logistics_department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private Integer id;
    private List<ItemDto> items;
    private AddressDto loadingAddress;
    private AddressDto unloadingAddress;
    private UserDto customer;
    private ApplicationStatusDto status;
}
