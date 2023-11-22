package com.academy.logistics_department.mappers;

import com.academy.logistics_department.dto.UserDto;
import com.academy.logistics_department.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    void shouldProperlyMapDTOToModel() {
        //given
        User model = new User();
        model.setId(11);
        model.setFirstName("John");
        model.setPassword("12345678");

        //when
        UserDto dto = mapper.toDto(model);
        User model1 = mapper.toModel(dto);

        //then
        Assertions.assertNotNull(model1);
        Assertions.assertEquals(model.getId(), model1.getId());
        Assertions.assertEquals(model.getFirstName(), model1.getFirstName());
    }
}
