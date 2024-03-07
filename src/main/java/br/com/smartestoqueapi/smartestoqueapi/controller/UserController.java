package br.com.smartestoqueapi.smartestoqueapi.controller;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserResponseDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.converter.UserConverter;
import br.com.smartestoqueapi.smartestoqueapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/cadastrar-usuarios")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody UserRequestDTO userRequestDTO) {
        userService.cadastrarUsuario(userRequestDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/teste/{id}")
    public ResponseEntity<User> teste(@PathVariable("id") String username) {
        return ResponseEntity.ok(this.userService.teste(username));
    }

    @GetMapping("/buscar-usuarios")
    public ResponseEntity<List<User>> buscarTodosUsuarios() {

        return ResponseEntity.ok(this.userService.buscarTodosUsuarios());
    }

    @PostMapping("/entrar")
    public ResponseEntity<User> entrar(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.entrar(userRequestDTO.getEmail(), userRequestDTO.getPassword());

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @DeleteMapping("/deletar-usuarios/{username}")
    public ResponseEntity<Void> deletarUsuarioPorUsername(@PathVariable("username") String username) {
        this.userService.deletarUsuarioPorUsername(username);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDTO> alterarUsernameEOuEmailPorId(@PathVariable("username") String id,
                                                                        @RequestBody UserRequestDTO usuarioDTO) {
        User usuarioAlterado = this.userService.alterarUsernameEOuEmailPorId(id, usuarioDTO);
        return ResponseEntity.ok(UserConverter.converterParaDTO(usuarioAlterado));
    }
}
