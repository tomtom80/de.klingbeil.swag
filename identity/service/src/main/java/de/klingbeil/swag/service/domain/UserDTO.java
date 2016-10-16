package de.klingbeil.swag.service.domain;

import de.klingbeil.swag.persistence.model.User;

public class UserDTO {

	private Long id;
	private String email;
	private String loginName;
	private String firstName;
	private String lastName;

	public UserDTO() {
		// spring dto conversion needs an public no arg constructor
	}

	private UserDTO(Builder builder) {
		this.id = builder.id;
		this.loginName = builder.loginName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
	}

	public Long getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public User toUser() {
		return new User.Builder(getId()).email(getEmail()).lastName(getLastName())
				.loginName(getLoginName()).firstName(getFirstName()).build();
	}

	public static class Builder {
		private Long id;
		private String loginName;
		private String firstName;
		private String lastName;
		private String email;

		public Builder(Long id) {
			this.id = id;
		}

		public Builder loginName(String loginName) {
			this.loginName = loginName;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDTO build() {
			return new UserDTO(this);
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}
	}

	public static UserDTO from(User user) {
		return new UserDTO.Builder(user.getId()).email(user.getEmail())
				.loginName(user.getLoginName()).lastName(user.getLastName())
				.firstName(user.getFirstName()).build();
	}
}
