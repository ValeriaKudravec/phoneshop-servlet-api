<%@ page contentType="text/html;charset=UTF-8" errorPage="exeptionPage.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="productPriceHistory" type="com.es.phoneshop.model.product.Product" scope="request"/>
<tags:master pageTitle="Product price history">
<h1>Price history</h1>
  <h3>${productPriceHistory.description}</h3>
  <table >
    <thead>
    <tr>
      <td>
        Date
      </td>
      <td>
        Price
      </td>
    </tr>
    </thead>
    <c:forEach var="price" items="${productPriceHistory.priceHistory}">
      <tr>
        <td>
         ${price.priceDate}
        </td>

        <td class="price">
          <fmt:formatNumber value="${price.price}" type="currency" currencySymbol="${price.price.currency.symbol}"/>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td>
        now
      </td>
      <td>
        ${productPriceHistory.price.price}
      </td>
    </tr>
  </table>
</tags:master>