package br.com.smartestoqueapi.smartestoqueapi.service;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.converter.UserConverter;
import br.com.smartestoqueapi.smartestoqueapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private static final String MENSAGEM_PARA_NOME_EXISTENTE = "O nome de usuário já possui um cadastro no Banco de Dados";

    private static final String MENSAGEM_EMAIL_NOME_EXISTENTE = "O e-mail já possui um cadastro no Banco de Dados";
    private static final String MENSAGEM_PARA_USERNAME_INEXISTENTE = "Não é possível deletar um Usuário inexistente.";
    private static final String MENSAGEM_PARA_ID_INEXISTENTE = "Não é possível alterar um Usuário inexistente.";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User cadastrarUsuario(UserRequestDTO userRequestDTO) {
        String username = userRequestDTO.getUsername();
        String email = userRequestDTO.getEmail();

        User usuarioExistentePorUsername = buscarUsuarioPorUsername(username);
        User usuarioExistentePorEmail = buscarUsuarioPorEmail(email);

        if (usuarioExistentePorUsername != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_PARA_NOME_EXISTENTE);
        }

        if (usuarioExistentePorEmail != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_EMAIL_NOME_EXISTENTE);
        }

        User usuarioParaAdicionar = UserConverter.converterParaEntidade(userRequestDTO);
        return userRepository.save(usuarioParaAdicionar);
    }

    public List<User> buscarTodosUsuarios() {
        return userRepository.findAll();
    }

    public User teste(String username) {
        return userRepository.findEmailByUsername(username);
    }

    public User buscarUsuarioPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User buscarUsuarioPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User buscarUsuarioPorPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public User entrar(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void deletarUsuarioPorUsername(String username) {
        User usuarioParaDeletar = userRepository.findByUsername(username);

        if (usuarioParaDeletar == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_USERNAME_INEXISTENTE
            );
        } else {
            userRepository.delete(usuarioParaDeletar);
        }
    }

    public User alterarUsernameEOuEmailPorId(String id, UserRequestDTO usuarioRequestDTO) {
        Optional<User> usuarioOptionalParaAlterar = userRepository.findById(id);

        if (usuarioOptionalParaAlterar.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_ID_INEXISTENTE
            );
        } else {
            User usuarioParaAlterar = usuarioOptionalParaAlterar.get();
            String nameUser = usuarioRequestDTO.getUsername();

            if (nameUser != null) {
                usuarioParaAlterar.setUsername(nameUser);
            }

            String email = usuarioRequestDTO.getEmail();
            if (email != null) {
                usuarioParaAlterar.setEmail(email);
            }

            userRepository.save(usuarioParaAlterar);

            return usuarioParaAlterar;
        }

    }

}