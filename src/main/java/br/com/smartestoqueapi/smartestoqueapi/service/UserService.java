package br.com.smartestoqueapi.smartestoqueapi.service;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.converter.UserConverter;
import br.com.smartestoqueapi.smartestoqueapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private static final String MENSAGEM_PARA_NOME_EXISTENTE = "O nome de usuário já possui um cadastro no Banco de Dados";

    private static final String MENSAGEM_EMAIL_NOME_EXISTENTE = "O e-mail já possui um cadastro no Banco de Dados";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User cadastrarUsuario(UserRequestDTO userRequestDTO) {
        String nomeUsuario = userRequestDTO.getNome();
        String emailUsuario = userRequestDTO.getEmail();

        User usuarioExistentePorNome = buscarUsuarioPorNome(nomeUsuario);
        User usuarioExistentePorEmail = buscarUsuarioPorEmail(emailUsuario);

        // Verifica se usuário existe pelo seu nome
        if (usuarioExistentePorNome != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_PARA_NOME_EXISTENTE);
        }

        // Verifica se usuário existe pelo seu e-mail
        if (usuarioExistentePorEmail != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MENSAGEM_EMAIL_NOME_EXISTENTE);
        }

        // A partir daqui, pode adicionar o usuário no MongoDB
        User usuarioParaAdicionar = UserConverter.converterParaEntidade(userRequestDTO);
        return userRepository.save(usuarioParaAdicionar);
    }

    public List<User> buscarTodosUsuarios() {
        return userRepository.findAll();
    }

    public User buscarUsuarioPorNome(String nome) {
        return userRepository.findByNome(nome);
    }

    public User buscarUsuarioPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User buscarUsuarioPorPassword(String senha) {
        return userRepository.findBySenha(senha);
    }

    public User entrar(String email, String senha) {
        return userRepository.findByEmailAndSenha(email, senha);
    }
}