package com.data.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.data.DataJpaTestTwoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataJpaTestTwoApplication.class)
@WebAppConfiguration
public class DataJpaTestTwoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
