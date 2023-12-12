package br.com.smartestoqueapi.smartestoqueapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation = "users")
public class User {

    private Long id;

    private String nome;

    private String email;

    private String senha;

}
