package br.com.smartestoqueapi.smartestoqueapi.model.dto.converter;

import br.com.smartestoqueapi.smartestoqueapi.model.Product;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.ProductRequestDTO;

public class ProductConverter {

    public static Product converterParaEntidade(ProductRequestDTO productRequestDTO) {
        Product productEntity = new Product();
        productEntity.setName(productRequestDTO.getName());
        productEntity.setPrice(productRequestDTO.getPrice());
        productEntity.setSize(productRequestDTO.getSize());
        productEntity.setColor(productRequestDTO.getColor());
        productEntity.setQuantity(productRequestDTO.getQuantity());

        return productEntity;
    }

}
