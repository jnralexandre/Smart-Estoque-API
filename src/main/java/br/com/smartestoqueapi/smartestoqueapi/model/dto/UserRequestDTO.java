package br.com.smartestoqueapi.smartestoqueapi.model.dto;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String nome;
    private String email;
    private String senha;

}
