package br.com.smartestoqueapi.smartestoqueapi.model.dto;

import lombok.Data;

@Data
public class UserResponseDTO {

    private String username;
    private String email;
    private String password;

}
