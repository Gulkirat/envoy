<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<body>
<h1>Product List Page</h1>

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