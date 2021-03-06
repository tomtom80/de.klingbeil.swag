package de.klingbeil.swag.persistence.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.klingbeil.swag.config.FakeMongoConfig;
import de.klingbeil.swag.persistence.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = FakeMongoConfig.class)
public class UserRepositoryTest {

	@Resource
	private UserRepository userRepository;

	
	@Test
	public void testFindAll() {
		User build = new User.Builder(12321L).build();
		userRepository.save(build);
		
		List<User> users = userRepository.findAll();

		assertEquals(1, users.size());
	}
	
	@Test
	public void testFindByLoginName() throws Exception {
		String loginName = "rzufall";
		User build = new User.Builder(322L).loginName(loginName ).build();
		userRepository.save(build);
		
		User result = userRepository.findByLoginName(loginName);

		assertEquals(loginName, result.getLoginName());
	}
	
}
