package com.es.phoneshop.web;

import com.es.phoneshop.model.product.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class ProductListPageServlet extends HttpServlet {
    private ProductDao productDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productDao = new ArrayListProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query");
        SortOrder order= getSortOrder(request);
        SortField field = getSortField(request);
        request.setAttribute("products", productDao.findProducts(query, field,order));
        request.getRequestDispatcher("/WEB-INF/pages/productList.jsp").forward(request, response);
    }

    private SortField getSortField(HttpServletRequest request){
        String field = request.getParameter("field");
        if(field == null){
            return null;
        }
        return SortField.valueOf(field);
    }

    private SortOrder getSortOrder(HttpServletRequest request){
        String order = request.getParameter("order");
        if(order == null){
            return null;
        }
        return SortOrder.valueOf(order);
    }

}
