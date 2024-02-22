package br.com.smartestoqueapi.smartestoqueapi.repository;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByPassword(String password);

    User findByEmailAndPassword(String email, String password);

    @Query(value = "{'username': ?0}", fields = "{'email': 0}")
    User findEmailByUsername(String username);
}
