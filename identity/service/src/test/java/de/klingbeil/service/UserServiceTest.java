package de.klingbeil.service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import de.klingbeil.domain.User;

public class UserServiceTest {

	private UserServiceImpl service;
	
	@Resource

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new UserServiceImpl();
	}
	
	@Test
	public void testSave() {
		User user = new User.Builder(1L).build();
		
		service.persist( user);
	}

}
