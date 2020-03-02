package com.concretepage.client;

import com.concretepage.client.controller.ArticleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringBootDemoApplicationTests {
	@Autowired
	ArticleController articleController;

	@Test
	void contextLoads() {

		assertThat(articleController).isNotNull();
	}

}
