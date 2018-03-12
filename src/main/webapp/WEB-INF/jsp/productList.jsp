<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<body>
<h1>Product List Page</h1>

<c:set var="selectedCurrency" value="${sessionScope.currency}"/>

<form action="/product/list/currency" method="post">
	<select id="currency" name="currency" onchange="this.form.submit()">
		<c:forEach var="currency" items="${currencies}">
			<c:choose>
				<c:when test="${currency == selectedCurrency}">
					<option value="${currency}" selected="selected">${currency}</option>
				</c:when>
				<c:otherwise>
					<option value="${currency}">${currency}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</form>

<c:forEach var="product" items="${products}">
	<table>
		<tr>
			<td>${product.name}</td>
			<c:forEach var="item" items="${product.prices}">
				<c:set var="price" value="${item.value}" />
				<td>${price.currency} ${price.amount}</td>
			</c:forEach>
		</tr>
	</table>
</c:forEach>

</body>
</html>