package de.klingbeil.service.internal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import de.klingbeil.domain.User;
import de.klingbeil.persistence.UserRepository;
import de.klingbeil.service.UserService;

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
