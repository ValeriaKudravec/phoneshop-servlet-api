package com.es.phoneshop.model.comparators;

import com.es.phoneshop.model.product.Product;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;

public class WordsCountComparator implements Comparator<Pair<Product, Integer>> {

    @Override
    public int compare(Pair<Product, Integer> first, Pair<Product, Integer> second) {
        return -first.getValue().compareTo(second.getValue());
    }
}
