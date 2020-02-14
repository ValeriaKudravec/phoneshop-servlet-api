package com.es.phoneshop.model.exeption;

public class ProductNotFoundExeption extends RuntimeException {

    private Long id;

    public ProductNotFoundExeption(Long Id) {
        this.id = id;
    }
}
