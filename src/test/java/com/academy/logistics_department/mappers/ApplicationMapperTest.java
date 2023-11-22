package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.dto.ApplicationStatusDto;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationMapperTest {

    @Autowired
    private ApplicationMapper mapper;

    @Test
    void shouldProperlyMapModelToDto() {
        //given
        Application model = new Application();
        model.setId(11);
        model.setStatus(ApplicationStatus.builder().id(1).statusName(ApplicationStatusEnum.ON_THE_WAY).build());

        //when
        ApplicationDto dto = mapper.toDto(model);

        //then
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(model.getId(), dto.getId());
        Assertions.assertEquals(model.getStatus().getStatusName(), dto.getStatus().getStatusName());
    }

    @Test
    void shouldProperlyMapDtoToModel() {
        //given
        ApplicationDto dto = new ApplicationDto();
        dto.setId(11);
        dto.setStatus(new ApplicationStatusDto(1, ApplicationStatusEnum.ON_THE_WAY));

        //when
        Application model = mapper.toModel(dto);

        //then
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(model.getId(), dto.getId());
        Assertions.assertEquals(model.getStatus().getStatusName(), dto.getStatus().getStatusName());
    }
}
