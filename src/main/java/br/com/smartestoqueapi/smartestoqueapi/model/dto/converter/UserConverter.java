package br.com.smartestoqueapi.smartestoqueapi.model.dto.converter;

import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserResponseDTO;

public class UserConverter {

    public static User converterParaEntidade(UserRequestDTO userRequestDTO) {
        User userEntity = new User();
        userEntity.setUsername(userRequestDTO.getUsername());
        userEntity.setEmail(userRequestDTO.getEmail());
        userEntity.setPassword(userRequestDTO.getPassword());

        return userEntity;
    }

    public static UserResponseDTO converterParaDTO(User usuario) {
        UserResponseDTO usuarioResponseDTO = new UserResponseDTO();
        usuarioResponseDTO.setUsername(usuario.getUsername());
        usuarioResponseDTO.setEmail(usuario.getEmail());

        return usuarioResponseDTO;
    }
}
