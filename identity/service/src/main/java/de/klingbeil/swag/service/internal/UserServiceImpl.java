package de.klingbeil.swag.service.internal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import de.klingbeil.swag.persistence.model.User;
import de.klingbeil.swag.persistence.repository.UserRepository;
import de.klingbeil.swag.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserRepository userRepository;

	@Override
	public User persist(User user) {
		userRepository.save(user);
		return user;
	}

}
