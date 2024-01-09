package br.com.smartestoqueapi.smartestoqueapi.repository;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByNome(String nome);

    User findByEmail(String email);

    User findBySenha(String senha);

    User findByEmailAndSenha(String email, String senha);
}
