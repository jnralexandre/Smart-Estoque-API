package br.com.smartestoqueapi.smartestoqueapi.model.dto.converter;


import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.UserRequestDTO;

public class UserConverter {

    public static User converterParaEntidade(UserRequestDTO userRequestDTO) {
        User userEntity = new User();
        userEntity.setNome(userRequestDTO.getNome());
        userEntity.setEmail(userRequestDTO.getEmail());
        userEntity.setSenha(userRequestDTO.getSenha());

        return userEntity;
    }

}
