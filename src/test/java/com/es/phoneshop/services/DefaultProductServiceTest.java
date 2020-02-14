package com.es.phoneshop.services;

import com.es.phoneshop.model.product.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DefaultProductServiceTest {
    ProductDao productDao = ArrayListProductDao.getInstance();
    DefaultProductService defPrServ;

    @BeforeEach
    public void init(){
        defPrServ = new DefaultProductService(productDao);
    }
    @Test
    public void testSearchProducts() {
        List<Product> result = defPrServ.searchProducts("Samsung Galaxy II", SortField.price, SortOrder.asc);
        List<Product> hardList = new ArrayList<>();
        productDao.save(new Product(3L, "sgs3",
                "Samsung Galaxy S III", new Price(new BigDecimal(300)), Currency.getInstance("USD"), 5,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S%20III.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(1L, "sgs3",
                "Samsung Galaxy S III", new Price(new BigDecimal(300)), Currency.getInstance("USD"), 5,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S%20III.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
       boolean isCorrect = true;
       for(int i = 0; i < result.size(); i++){
           if(!result.get(i).equals(hardList.get(i))){
               isCorrect = false;
           }
       }
       assertTrue(isCorrect);
    }

    @BeforeEach
    void setUp() {
    }

}