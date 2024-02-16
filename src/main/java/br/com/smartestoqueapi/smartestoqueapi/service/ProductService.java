package br.com.smartestoqueapi.smartestoqueapi.service;

import br.com.smartestoqueapi.smartestoqueapi.model.Product;
import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.ProductRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.converter.ProductConverter;
import br.com.smartestoqueapi.smartestoqueapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product cadastrarProduto(ProductRequestDTO productRequestDTO) {
        String name = productRequestDTO.getName();
        BigDecimal price = productRequestDTO.getPrice();
        String size = productRequestDTO.getSize();
        String color = productRequestDTO.getColor();
        Integer quantity = productRequestDTO.getQuantity();

        Product produtoParaAdicionar = ProductConverter.converterParaEntidade(productRequestDTO);
        return productRepository.save(produtoParaAdicionar);
    }

    public List<Product> buscarTodosProdutos() {
        return productRepository.findAll();
    }

}
