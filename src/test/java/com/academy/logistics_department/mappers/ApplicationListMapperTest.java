package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.ApplicationDto;
import com.academy.logistics_department.model.entity.Application;
import com.academy.logistics_department.model.entity.ApplicationStatus;
import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class ApplicationListMapperTest {

    @Autowired
    private ApplicationListMapper mapperUnderTest;

    @Test
    void shouldProperlyMapDtoToModel() {
        //given
        ApplicationDto dto = new ApplicationDto();
        dto.setId(11);
        dto.setStatus(ApplicationStatus.builder().id(1).statusName(ApplicationStatusEnum.ON_THE_WAY).build());

        List<ApplicationDto> dtos = Collections.singletonList(dto);

        //when
        List<Application> models = mapperUnderTest.toModelList(dtos);

        //then
        Assertions.assertNotNull(models);
        Assertions.assertEquals(1, models.size());
        Assertions.assertEquals(dto.getId(), dtos.get(0).getId());
        Assertions.assertEquals(dto.getStatus(), dtos.get(0).getStatus());
    }
}
