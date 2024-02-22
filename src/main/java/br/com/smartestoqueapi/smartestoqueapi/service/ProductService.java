package br.com.smartestoqueapi.smartestoqueapi.service;

import br.com.smartestoqueapi.smartestoqueapi.model.Product;
import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.ProductRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.converter.ProductConverter;
import br.com.smartestoqueapi.smartestoqueapi.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private static final String MENSAGEM_PARA_NOME_INEXISTENTE = "Não é possível deletar um Produto inexistente.";

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

    public void deletarProdutoPorNome(String name) {
        Product produtoParaDeletar = productRepository.findByName(name);

        if (produtoParaDeletar == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, MENSAGEM_PARA_NOME_INEXISTENTE
            );
        } else {
            productRepository.delete(produtoParaDeletar);
        }
    }

}
