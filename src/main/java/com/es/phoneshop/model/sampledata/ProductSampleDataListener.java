package com.es.phoneshop.model.sampledata;

import com.es.phoneshop.model.product.ArrayListProductDao;
import com.es.phoneshop.model.product.Price;
import com.es.phoneshop.model.product.Product;
import com.es.phoneshop.model.product.ProductDao;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;

public class ProductSampleDataListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ProductDao productDao = ArrayListProductDao.getInstance();
        init(productDao);
    }

    public void init(ProductDao productDao) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

        Currency usd = Currency.getInstance("USD");
        productDao.save(new Product(null, "sgs3",
                "Samsung Galaxy S III", new Price(new BigDecimal(300)), usd, 5,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S%20III.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "sgs2",
                "Samsung Galaxy S II", new Price(new BigDecimal(200)), usd, 0,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S%20II.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "sgs3",
                "Samsung Galaxy S III", new Price(new BigDecimal(300)), usd, 5,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Samsung/Samsung%20Galaxy%20S%20III.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "iphone",
                "Apple iPhone", new Price(new BigDecimal(200)), usd, 10,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Apple/Apple%20iPhone.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06"))));
        productDao.save(new Product(null, "iphone6",
                "Apple iPhone 6", new Price(new BigDecimal(1000)), usd, 30,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Apple/Apple%20iPhone%206.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "htces4g",
                "HTC EVO Shift 4G", new Price(new BigDecimal(320)), usd, 3,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/HTC/HTC%20EVO%20Shift%204G.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06"))));
        productDao.save(new Product(null, "sec901",
                "Sony Ericsson C901", new Price(new BigDecimal(420)), usd, 30,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Sony/Sony%20Ericsson%20C901.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "xperiaxz",
                "Sony Xperia XZ", new Price(new BigDecimal(120)), usd, 100,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Sony/Sony%20Xperia%20XZ.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "nokia3310",
                "Nokia 3310", new Price(new BigDecimal(70)), usd, 100,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Nokia/Nokia%203310.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06"))));
        productDao.save(new Product(null, "palmp",
                "Palm Pixi", new Price(new BigDecimal(170)), usd, 30,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Palm/Palm%20Pixi.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "simc56",
                "Siemens C56", new Price(new BigDecimal(70)), usd, 20,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Siemens/Siemens%20C56.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06"))));
        productDao.save(new Product(null, "simc61",
                "Siemens C61", new Price(new BigDecimal(80)), usd, 30,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Siemens/Siemens%20C61.jpg",
                Arrays.asList(new Price(new BigDecimal(200), "2016-11-12"), new Price(new BigDecimal(210), "2019-02-02"),
                        new Price(new BigDecimal(220), "2020-01-02"))));
        productDao.save(new Product(null, "simsxg75",
                "Siemens SXG75", new Price(new BigDecimal(150)), usd, 40,
                "https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/manufacturer/Siemens/Siemens%20SXG75.jpg",
                Arrays.asList(new Price(new BigDecimal(50), "2019-11-02"), new Price(new BigDecimal(70), "2018-12-12"),
                        new Price(new BigDecimal(80), "2017-09-06"))));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
