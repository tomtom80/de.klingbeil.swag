package de.klingbeil.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.klingbeil.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
