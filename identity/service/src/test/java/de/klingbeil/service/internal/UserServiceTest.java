package de.klingbeil.service.internal;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.klingbeil.domain.User;
import de.klingbeil.persistence.UserRepository;
import de.klingbeil.service.internal.UserServiceImpl;

public class UserServiceTest {

	private UserServiceImpl service;
	
	@Mock
	UserRepository userRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		service = new UserServiceImpl();
		service.userRepository = userRepository;
	}
	
	@Test
	public void testSave() {
		User user = new User.Builder(1L).build();
		when(userRepository.save(user)).thenReturn(user);
		
		User result = service.persist( user);
		
		assertSame(user, result);
		verify(userRepository).save(user);
	}

}
