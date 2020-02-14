<%@ page contentType="text/html;charset=UTF-8" errorPage="exeptionPage.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="products" type="java.util.ArrayList" scope="request"/>
<tags:master pageTitle="Product List">
<p>
  Welcom to phoneshop
</p>
  <form>
    <input name="query" value="${param.query}">
    <button>Search</button>
  </form>
  <table>
    <thead>
      <tr>
        <td>Image</td>
        <td>
          Description
          <a  href="products?query=${param.query}&field=description&order=asc">asc</a>
          <a  href="products?query=${param.query}&field=description&order=desc">desc</a>
        </td>

        <td class="price">
          Price
          <a  href="products?query=${param.query}&field=price&order=asc">asc</a>
          <a  href="products?query=${param.query}&field=price&order=desc">desc</a>
        </td>
      </tr>
    </thead>
    <c:forEach var="product" items="${products}">
      <tr>
        <td>
          <img class="product-tile" src="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${product.imageUrl}">
        </td>
        <td>
          <a href="products/${product.id}">${product.description}</a>
        </td>
        <td class="price">
          <a href="products/priceHistory/${product.id}">$${product.price.price}</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</tags:master>