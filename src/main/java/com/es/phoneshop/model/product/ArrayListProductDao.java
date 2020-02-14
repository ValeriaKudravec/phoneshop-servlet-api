package com.es.phoneshop.model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArrayListProductDao implements ProductDao {

    private static ArrayListProductDao instance;
    private List<Product> productList;
    private Long maxId;

    private ArrayListProductDao() {
        this.productList = new ArrayList<>();
        maxId = 0L;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();

    }

    @Override
    public List<Product> findProducts() {
        return productList.stream()
                .filter(product -> (product.getStock() > 0))
                .filter(product -> product.getPrice() != null)
                .collect(Collectors.toList());
    }

    @Override
    public synchronized void save(Product product) {
        if (product.getId() == null) {
            product.setId(++maxId);
            productList.add(product);
            return;
        } else {
            productList.forEach(product1 -> {
                if (product1.getId().equals(maxId)) {
                    update(product, product1);
                    return;
                }
            });
        }
        productList.add(product);
    }

    private void update(Product product, Product newProduct) {
        newProduct.setCode(product.getCode());
        newProduct.setCurrency(product.getCurrency());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setImageUrl(product.getImageUrl());
        newProduct.setStock(product.getStock());
    }

    @Override
    public synchronized void delete(Long id) {

        productList.removeIf(p -> Objects.equals(p.getId(), id));
    }

    public static ArrayListProductDao getInstance() {
        if (instance == null) {
            instance = new ArrayListProductDao();
        }
        return instance;
    }
}
