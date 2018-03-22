<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<body>
	<h1>Product Edit Page</h1>

	<a href="/product/list">View Product List</a>

	<form method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="description" value="${product.name}" /></td>
			</tr>
				<c:forEach var="item" items="${product.prices}">
					<c:set var="price" value="${item.value}" />
					<tr>
						<td>Price in ${price.currency.currencyCode} (${price.currency.symbol})</td>
						<td><input type="text" name="${price.currency.currencyCode}" value="${price.amount}"/></td>
					</tr>
				</c:forEach>
		</table>
		<input type="submit" value="Save Changes" />
	</form>
</body>
</html>