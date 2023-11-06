package com.academy.logistics_department.service;

import com.academy.logistics_department.model.entity.Application;

import java.util.List;

public interface CustomerService {
    List<Application> getAllCustomersApplications();
    void createApplication(Application application);
    void changeApplication(Integer id);
}
