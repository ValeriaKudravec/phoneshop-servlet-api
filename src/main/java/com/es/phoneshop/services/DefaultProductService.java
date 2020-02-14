package com.es.phoneshop.services;

import com.es.phoneshop.model.comparators.ProductComparator;
import com.es.phoneshop.model.comparators.WordsCountComparator;
import com.es.phoneshop.model.product.Product;
import com.es.phoneshop.model.product.ProductDao;
import com.es.phoneshop.model.product.SortField;
import com.es.phoneshop.model.product.SortOrder;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultProductService implements ProductService {

    private ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> searchProducts(String query, SortField field, SortOrder order) {
        String[] words;
        if (query != null) {
            words = query.split(" ");
        } else {
            words = new String[0];
        }

        List<Pair<Product, Integer>> prodWithCountOfMatch = productDao.findProducts().stream()
                .map(product -> makePair(words, product)).filter(pairProduct -> pairProduct.getValue() != 0).collect(Collectors.toList());

        Stream<Product> filteredProducts = prodWithCountOfMatch.stream().sorted(new WordsCountComparator())
                .map(Pair::getKey);
        if (field != null) {
            filteredProducts = filteredProducts.sorted(new ProductComparator(field, order));
        }
        List<Product> result = filteredProducts.collect(Collectors.toList());
        return result;
    }

    private Pair<Product, Integer> makePair(String[] words, Product product) {
        return new MutablePair<>(product, findCountOfWords(words, product));
    }

    private int findCountOfWords(String[] words, Product product) {
        if (words.length == 0) {
            return 1;
        }
        int count = 0;
        for (String word : words) {
            if (product.getDescription().contains(word)) {
                count++;
            }
        }
        return count;
    }
}
