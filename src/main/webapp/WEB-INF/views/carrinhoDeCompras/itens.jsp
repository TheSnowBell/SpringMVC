<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert titulo here</title>
</head>
<body>


	<table id="cart-table">
		<thead>
			<tr>
				<th class="cart-img-col"></th>
				<th width="65%">Item</th>
				<th width="10%">Preço</th>
				<th width="10%">Quantidade</th>
				<th width="10%">Total</th>
				<th width="5%"></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${carrinhoDeCompra.list}" var="item">
				<tr>
					<td class="cart-img-col"><img src=""
						alt="${item.produto.titulo}" /></td>
					<td class="item-titulo">${item.produto.titulo} - ${item.bookType}
					</td>
					<td class="numeric-cell">${item.preco}</td>
					<td class="quantity-input-cell"><input type="number" min="0"
						readonly="readonly" value="${carrinhoDeCompra.getQuantidadeDoItem(item)}">
					</td>
					<td class="numeric-cell">${carrinhoDeCompra.getValorTotalDoItem(item)}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<form action="${spring:mvcUrl('PC#checkout').build()}"
						method="post">
						<input type="submit" class="checkout" name="checkout"
							value="Finalizar compra " id="checkout" />
					</form>
				</td>
				<td class="numeric-cell">${carrinhoDeCompra.total}</td>
				<td></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>