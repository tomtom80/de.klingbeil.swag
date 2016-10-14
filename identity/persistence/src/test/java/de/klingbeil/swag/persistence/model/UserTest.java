package de.klingbeil.swag.persistence.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.klingbeil.swag.persistence.model.User;

public class UserTest {

	private static final Long ID = Long.valueOf(2);

	@Test
	public void testUser() throws Exception {
		
		User user = new User.Builder(ID).build();

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
		String lastName ="Klingbeil";
		
		User user = new User.Builder(ID).lastName(lastName).build();

		assertEquals(lastName, user.getLastName());
	}

	@Test
	public void testEmail() throws Exception {
		String email = "tom.klingbeil@gmail.com";
		
		User user = new User.Builder(ID).email(email).build();

		assertEquals(email, user.getEmail());
	}
}
