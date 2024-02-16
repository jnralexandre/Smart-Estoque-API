package br.com.smartestoqueapi.smartestoqueapi.repository;

import br.com.smartestoqueapi.smartestoqueapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);
}
