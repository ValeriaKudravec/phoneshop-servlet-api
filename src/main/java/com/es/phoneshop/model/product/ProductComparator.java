package com.es.phoneshop.model.product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    private SortField field;
    private SortOrder order;
    public ProductComparator(SortField field, SortOrder order){
        this.field=field;
        this.order=order;
    }
    @Override
    public int compare(Product a, Product b) {
        switch (this.field){
            case price:{
                switch (this.order){
                    case asc:return a.getPrice().compareTo(b.getPrice());
                    case desc:return -a.getPrice().compareTo(b.getPrice());
                    default:return 0;
                }
            }
            case description:{
                switch (this.order){
                    case asc:return a.getDescription().compareTo(b.getDescription());
                    case desc:return -a.getDescription().compareTo(b.getDescription());
                    default:return 0;
                }
            }
            default:return 0;
        }
    }
}
