package br.com.smartestoqueapi.smartestoqueapi.repository;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    public User findByNome(String nome);

    public User findByEmail(String email);

    public User findBySenha(String senha);

    public User findByEmailAndSenha(String email, String senha);

}
