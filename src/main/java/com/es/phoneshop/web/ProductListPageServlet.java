package com.es.phoneshop.web;

import com.es.phoneshop.model.product.ArrayListProductDao;
import com.es.phoneshop.model.product.ProductDao;
import com.es.phoneshop.model.product.SortField;
import com.es.phoneshop.model.product.SortOrder;
import com.es.phoneshop.services.DefaultProductService;
import com.es.phoneshop.services.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProductListPageServlet extends HttpServlet {
    private ProductDao productDao;
    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productDao = ArrayListProductDao.getInstance();
        productService = new DefaultProductService(productDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        SortOrder order = getSortOrder(request);
        SortField field = getSortField(request);
        request.setAttribute("products", productService.searchProducts(query, field, order));
        request.getRequestDispatcher("/WEB-INF/pages/productList.jsp").forward(request, response);
    }

    private SortField getSortField(HttpServletRequest request) {
        String field = request.getParameter("field");
        if (field == null) {
            return null;
        }
        return SortField.valueOf(field);
    }

    private SortOrder getSortOrder(HttpServletRequest request) {
        String order = request.getParameter("order");
        if (order == null) {
            return null;
        }
        return SortOrder.valueOf(order);
    }

}
