package com.academy.logistics_department;

import com.academy.logistics_department.model.entity.User;
import com.academy.logistics_department.model.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogisticsDepartmentApplicationTests {

	@Autowired
	private UserRepository repositoryUnderTest;

	@Test
	@DisplayName("Without password in entity")
	void saveUserTest() {
		//given
		User user = repositoryUnderTest.getReferenceById(1);
		user.setFirstName("Vasia");
		user.setLastName("Ivanov");

		//then
		Assertions.assertDoesNotThrow(() -> repositoryUnderTest.save(user));
	}

}
