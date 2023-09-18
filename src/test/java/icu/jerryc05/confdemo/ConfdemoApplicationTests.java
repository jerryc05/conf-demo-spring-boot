package icu.jerryc05.confdemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import icu.jerryc05.confdemo.controllers.SessionsController;

@SpringBootTest
class ConfdemoApplicationTests {

	@Autowired
	private SessionsController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}
}
