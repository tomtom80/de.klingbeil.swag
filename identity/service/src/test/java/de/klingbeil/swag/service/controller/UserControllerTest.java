package de.klingbeil.swag.service.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.klingbeil.swag.APIUrls;
import de.klingbeil.swag.config.FakeMongoConfig;
import de.klingbeil.swag.persistence.model.User;
import de.klingbeil.swag.service.UserService;
import de.klingbeil.swag.service.domain.UserDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
@ContextConfiguration(classes = { FakeMongoConfig.class })
public class UserControllerTest {

	private static final String LOGIN_NAME = "rzufall";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testGetUserByLoginName() throws Exception {
		User user = new User.Builder(323L).loginName(LOGIN_NAME).build();
		when(userService.findByLoginName(LOGIN_NAME)).thenReturn(user);

		this.mvc.perform(get(APIUrls.USERS_RESOURCE + "/{loginName}", LOGIN_NAME))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().string(json(UserDTO.from(user))));

	}

	@Test
	public void testCreateUser() throws Exception {
		String userJson = json(new UserDTO.Builder(23L).loginName(LOGIN_NAME).build());

		this.mvc.perform(post(APIUrls.USERS_RESOURCE)
				.contentType("application/json;charset=UTF-8").content(userJson))
				.andExpect(status().isCreated());

		assertEquals(LOGIN_NAME, captureOnPersist().getLoginName());
	}

	private User captureOnPersist() {
		ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
		verify(userService).persist(captor.capture());
		return captor.getValue();
	}

	private String json(UserDTO user) throws JsonProcessingException {
		return this.mapper.writeValueAsString(user);
	}

}
