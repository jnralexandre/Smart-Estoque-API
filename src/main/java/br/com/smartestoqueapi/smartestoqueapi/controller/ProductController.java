package br.com.smartestoqueapi.smartestoqueapi.controller;

import br.com.smartestoqueapi.smartestoqueapi.model.Product;
import br.com.smartestoqueapi.smartestoqueapi.model.User;
import br.com.smartestoqueapi.smartestoqueapi.model.dto.ProductRequestDTO;
import br.com.smartestoqueapi.smartestoqueapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/cadastrar-produtos")
    public ResponseEntity<Product> cadastrarUsuario(@RequestBody ProductRequestDTO productRequestDTO) {
        productService.cadastrarProduto(productRequestDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar-produtos")
    public ResponseEntity<List<Product>> buscarTodosProdutos() {

        return ResponseEntity.ok(this.productService.buscarTodosProdutos());
    }

}
