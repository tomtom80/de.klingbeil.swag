package de.klingbeil.swag.service;

import de.klingbeil.swag.persistence.model.User;

public interface UserService {

	User persist(User user);

	User findByLoginName(String loginName);

}