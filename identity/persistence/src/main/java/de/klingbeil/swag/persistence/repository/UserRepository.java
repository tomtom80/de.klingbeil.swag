package de.klingbeil.swag.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.klingbeil.swag.persistence.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
