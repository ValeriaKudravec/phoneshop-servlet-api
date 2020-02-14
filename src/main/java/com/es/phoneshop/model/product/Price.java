package com.es.phoneshop.model.product;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Price {

    private Date priceDate;
    private BigDecimal price;
    private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    public Price(Date priceDate, BigDecimal price) {
        this.price = price;
        this.priceDate = priceDate;
    }

    public Price(BigDecimal price) {
        this.price = price;
        this.priceDate = new Date();
    }

    public Price(BigDecimal price, String date) {
        this.price = price;
        try {
            this.priceDate = ft.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() == Price.class)) return false;

        Price price1 = (Price) o;

        if (!price.equals(price1.price)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = priceDate != null ? priceDate.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (ft != null ? ft.hashCode() : 0);
        return result;
    }
}
