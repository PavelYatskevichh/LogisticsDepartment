package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.CategoryDto;
import com.academy.logistics_department.model.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface CategoryListMapper {
    List<Category> toModelList(List<CategoryDto> categoryDtoList);
    List<CategoryDto> toDtoList(List<Category> categories);
}
