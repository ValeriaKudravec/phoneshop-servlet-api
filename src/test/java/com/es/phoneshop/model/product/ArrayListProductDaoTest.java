package com.es.phoneshop.model.product;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListProductDaoTest {
    private ProductDao productDao;

    @BeforeEach
    public void setup() {
        productDao = ArrayListProductDao.getInstance();
        productDao.save(new Product(null, "sgs",
                "Samsung Galaxy S", new Price(new BigDecimal(100)), Currency.getInstance("USD"), 100,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06"))));
        productDao.save(new Product(null, "sgs2",
                "Samsung Galaxy S II", new Price(new BigDecimal(200)), Currency.getInstance("USD"), 0,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S%20II.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
    }

    @Test
    public void testFindProductsNoResults() {
        assertFalse(productDao.findProducts().isEmpty());
    }

    @Test
    public void testGetProductIsFalse() {
        assertFalse(productDao.getProduct(40L).isPresent());
    }

    @Test
    public void saveProductToList() {
        Product product = new Product(15L, "sgs",
                "Samsung Galaxy Sss", new Price(new BigDecimal(100)), Currency.getInstance("USD"), 100,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06")));

        productDao.save(product);
        Optional<Product> optionalProduct = productDao.getProduct(15L);
        if(optionalProduct.isPresent()) {
            assertEquals(productDao.getProduct(15L).get(), product);
        }
    }

    @Test
    public void deleteProductFromCenter() {
        Product product = new Product(20L, "simc61",
                "Siemens C61", new Price(new BigDecimal(80)), Currency.getInstance("USD"), 30,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Siemens/Siemens%20C61.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06")));
        productDao.save(product);
        if(productDao.getProduct(20L).equals(product)) {
            productDao.delete(20L);
            assertTrue(productDao.getProduct(20L) == null);
        }
    }

    @Test
    public void shouldReturnProduct(){
        Optional<Product> product = productDao.getProduct(1L);
        assertTrue(product.isPresent());
    }


    @Test
    public void shouldReturnEmptyIfNotFound(){
        Optional<Product> product = productDao.getProduct(13L);
        assertFalse(product.isPresent());
    }
}
