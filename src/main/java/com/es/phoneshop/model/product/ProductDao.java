package com.es.phoneshop.model.product;

import com.es.phoneshop.model.exeption.ProductNotFoundExeption;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface ProductDao {
    Optional<Product> getProduct(Long id);
    List<Product> findProducts();
    void save(Product product);
    void delete(Long id);
}
