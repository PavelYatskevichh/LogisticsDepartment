package com.academy.logistics_department.service.impl;

import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.Route;
import com.academy.logistics_department.model.repository.ApplicationRepository;
import com.academy.logistics_department.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> getAllManagersApplications() {
        return null;
    }

    @Override
    public void createRoute(Route route) {

    }

    @Override
    public void changeRoute(Integer id) {

    }
}
