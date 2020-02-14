package com.es.phoneshop.model.comparators;

import com.es.phoneshop.model.product.Product;
import com.es.phoneshop.model.product.SortField;
import com.es.phoneshop.model.product.SortOrder;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    private SortField field;
    private SortOrder order;

    public ProductComparator(SortField field, SortOrder order) {
        this.field = field;
        this.order = order;
    }

    @Override
    public int compare(Product first, Product second) {
        if (field == null) {
            return 0;
        }
        switch (this.field) {
            case price: {
                return sortByPrice(first, second);
            }
            case description: {
                return sortByDescription(first, second);
            }
            default:
                return 0;
        }
    }

    @Override
    public Comparator<Product> reversed() {
        return null;
    }

    private int sortByPrice(Product first, Product second) {
        switch (this.order) {
            case asc:
                return first.getPrice().getPrice().compareTo(second.getPrice().getPrice());
            case desc:
                return -first.getPrice().getPrice().compareTo(second.getPrice().getPrice());
            default:
                return 0;
        }
    }

    private int sortByDescription(Product first, Product second) {
        switch (this.order) {
            case asc:
                return first.getDescription().compareTo(second.getDescription());
            case desc:
                return -first.getDescription().compareTo(second.getDescription());
            default:
                return 0;
        }
    }
}
