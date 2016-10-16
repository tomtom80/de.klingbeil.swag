package de.klingbeil.swag.configuration;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.klingbeil.swag.config.FakeMongoConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ FakeMongoConfig.class})
public class SwaggerConfigurationTest {

	@Resource
	private SwaggerConfiguration config;
	
	@Test
	public void testApis() throws Exception {
	}

}