package de.klingbeil.domain;

public class User {

	private Long id;
	private String loginName;
	private String firstName;
	private String lastName;
	private String email;

	private User(Builder builder) {
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

		public User build() {
			return new User(this);
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}
	}
}
