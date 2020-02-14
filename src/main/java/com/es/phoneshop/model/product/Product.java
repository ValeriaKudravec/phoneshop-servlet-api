package com.es.phoneshop.model.product;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;


public class Product {
    private Long id;
    private String code;
    private String description;
    /**
     * null means there is no price because the product is outdated or new
     */
    private Price price;
    /**
     * can be null if the price is null
     */
    private Currency currency;
    private int stock;
    private String imageUrl;
    private List<Price> priceHistory;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", currency=" + currency +
                ", stock=" + stock +
                ", imageUrl='" + imageUrl + '\'' +
                ", priceHistory=" + priceHistory +
                '}';
    }

    public List<Price> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<Price> priceHistory) {
        this.priceHistory = priceHistory;
    }

    public void changePrice(BigDecimal newPrice) {
        Price oldPrice = this.price;
        this.priceHistory.add(oldPrice);
        this.price = new Price(new Date(),newPrice);
    }

    public Product(Long id, String code, String description, Price price, Currency currency, int stock, String imageUrl, List<Price> priceHistory) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.priceHistory = priceHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() == Product.class)) return false;

        Product product = (Product) o;

        if (stock != product.stock) return false;
        if (!id.equals(product.id)) return false;
        if (!code.equals(product.code)) return false;
        if (!description.equals(product.description)) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (currency != null ? !currency.equals(product.currency) : product.currency != null) return false;
        if (!imageUrl.equals(product.imageUrl)) return false;
        return priceHistory != null ? priceHistory.equals(product.priceHistory) : product.priceHistory == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + (priceHistory != null ? priceHistory.hashCode() : 0);
        return result;
    }
}