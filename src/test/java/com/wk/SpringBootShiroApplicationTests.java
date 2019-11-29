package com.wk;

import com.wk.entity.User;
import com.wk.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootShiroApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		List<User> list = userService.list();
		for (User user : list) {
			System.out.println("user = " + user);
		}
	}

}
