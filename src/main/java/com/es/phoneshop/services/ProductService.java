package com.es.phoneshop.services;

import com.es.phoneshop.model.product.Product;
import com.es.phoneshop.model.product.SortField;
import com.es.phoneshop.model.product.SortOrder;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query, SortField sortField, SortOrder sortOrder);
}
