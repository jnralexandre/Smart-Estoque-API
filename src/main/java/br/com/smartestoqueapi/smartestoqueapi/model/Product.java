package br.com.smartestoqueapi.smartestoqueapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    @Id
    private String name;
    private BigDecimal price;
    private String size;
    private String color;
    private Integer quantity;

}
