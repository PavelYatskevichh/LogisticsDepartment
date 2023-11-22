package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ApplicationStatusDto;
import com.academy.logistics_department.dto.CategoryDto;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toModel(CategoryDto categoryDto);
    void updateModel(CategoryDto categoryDto, @MappingTarget Category category);
}
