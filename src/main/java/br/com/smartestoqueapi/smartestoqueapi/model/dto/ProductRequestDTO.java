package br.com.smartestoqueapi.smartestoqueapi.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    String name;
    BigDecimal price;
    String size;
    String color;
    Integer quantity;

}
