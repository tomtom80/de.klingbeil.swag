package de.klingbeil.swag.service.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.klingbeil.swag.config.FakeMongoConfig;
import de.klingbeil.swag.persistence.model.User;
import de.klingbeil.swag.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers =  UserController.class)
@ContextConfiguration(classes={ FakeMongoConfig.class})
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testGetUserByLoginName() throws Exception {
		String loginName = "rzufall";
		User user = new User.Builder(323L).loginName(loginName).build();
		when(userService.findByLoginName(loginName)).thenReturn(user);

		this.mvc.perform(get("/users/{loginName}", loginName))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().string(mapper.writeValueAsString(user)));

	}

}
