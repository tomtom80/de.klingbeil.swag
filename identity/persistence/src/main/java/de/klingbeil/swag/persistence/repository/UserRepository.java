package de.klingbeil.swag.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.klingbeil.swag.persistence.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	/**
	 * Find the {@link User} with the given login name. 
	 * 
	 * @param loginName users login name.
	 * @return {@link User}
	 */
	User findByLoginName(String loginName);

}
