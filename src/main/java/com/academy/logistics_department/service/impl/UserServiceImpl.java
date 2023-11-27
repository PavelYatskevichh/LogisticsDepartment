package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.dto.DriverDto;
import com.academy.logistics_department.mappers.DriverMapper;
import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.repository.UserRepository;
import com.academy.logistics_department.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final DriverMapper driverMapper;

    @Override
    public List<DriverDto> getAllDrivers() {
        User user = userRepository.getReferenceById(1);
        return userRepository
                .findAll()
                .stream()
                .filter(a -> !a.getCategories().isEmpty())
                .map(driverMapper::toDto)
                .toList();
    }
}
