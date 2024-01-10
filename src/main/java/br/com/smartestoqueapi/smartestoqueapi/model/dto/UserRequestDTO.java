package br.com.smartestoqueapi.smartestoqueapi.model.dto;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String username;
    private String email;
    private String password;

}
