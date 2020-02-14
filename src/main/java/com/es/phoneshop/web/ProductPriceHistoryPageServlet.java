package com.es.phoneshop.web;

import com.es.phoneshop.model.exeption.ProductNotFoundExeption;
import com.es.phoneshop.model.product.ArrayListProductDao;
import com.es.phoneshop.model.product.Product;
import com.es.phoneshop.model.product.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ProductPriceHistoryPageServlet extends HttpServlet {

    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        super.init();
        productDao = ArrayListProductDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getPathInfo() == null) {
            throw new ServletException(request.getPathInfo());
        }
        String path = request.getPathInfo().substring(1);
        Long productId = Long.valueOf(path);
        Optional<Product> optionalProduct = productDao.getProduct(productId);
        if (!optionalProduct.isPresent()) {
            throw new ProductNotFoundExeption(productId);
        }
        request.setAttribute("productPriceHistory", optionalProduct.get());
        request.getRequestDispatcher("/WEB-INF/pages/productPriceHistory.jsp").forward(request, response);
    }
}
