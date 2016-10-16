package de.klingbeil.swag.service.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.klingbeil.swag.persistence.model.User;

public class UserDTOTest {

	private static final Long ID = Long.valueOf(2);

	@Test
	public void testUser() throws Exception {

		UserDTO user = new UserDTO.Builder(ID).build();

		assertEquals(ID, user.getId());
	}

	@Test
	public void testLoginName() throws Exception {
		String loginName = "Tom";

		User user = new User.Builder(ID).loginName(loginName).build();

		assertEquals(loginName, user.getLoginName());

	}

	@Test
	public void testFirstName() throws Exception {
		String firstName = "Tom";

		User user = new User.Builder(ID).firstName(firstName).build();

		assertEquals(firstName, user.getFirstName());
	}

	@Test
	public void testLastName() throws Exception {
		String lastName = "Klingbeil";

		User user = new User.Builder(ID).lastName(lastName).build();

		assertEquals(lastName, user.getLastName());
	}

	@Test
	public void testEmail() throws Exception {
		String email = "tom.klingbeil@gmail.com";

		User user = new User.Builder(ID).email(email).build();

		assertEquals(email, user.getEmail());
	}

	@Test
	public void testFromUser() throws Exception {
		String email = null;
		String loginName = null;
		String firstName = null;
		String lastName = null;
		User user = new User.Builder(ID).loginName(loginName).email(email)
				.firstName(firstName).lastName(lastName).build();

		UserDTO result = UserDTO.from(user);

		assertEquals(email, result.getEmail());
		assertEquals(loginName, result.getLoginName());
		assertEquals(firstName, result.getFirstName());
		assertEquals(lastName, result.getLastName());
	}
	
	@Test
	public void testToUser() throws Exception {
		String email = null;
		String loginName = null;
		String firstName = null;
		String lastName = null;
		UserDTO user = new UserDTO.Builder(ID).loginName(loginName).email(email)
				.firstName(firstName).lastName(lastName).build();

		User result = user.toUser();

		assertEquals(email, result.getEmail());
		assertEquals(loginName, result.getLoginName());
		assertEquals(firstName, result.getFirstName());
		assertEquals(lastName, result.getLastName());
	}
}
