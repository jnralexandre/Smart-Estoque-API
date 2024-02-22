package br.com.smartestoqueapi.smartestoqueapi.repository;

import br.com.smartestoqueapi.smartestoqueapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {


    @Query
    Product findByName(String name);

}
