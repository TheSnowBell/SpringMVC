<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pageTemplate bodyClass="" title="Itens">

	<table id="cart-table">
		<thead>
			<tr>
				<th></th>
				<th>Item</th>
				<th>Preço</th>
				<th>Quantidade</th>
				<th>Total</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${carrinhoDeCompra.list}" var="item">
				<tr>
					<td><img src=""	alt="${item.produto.titulo}" /></td>
					<td>${item.produto.titulo} - ${item.bookType}</td>
					<td>${item.preco}</td>
					<td>
						<input type="number" min="0" readonly="readonly" value="${carrinhoDeCompra.getQuantidadeDoItem(item)}">
					</td>
					<td>${carrinhoDeCompra.getValorTotalDoItem(item)}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<form action="${spring:mvcUrl('PC#checkout').build()}"
						method="post">
						<input type="submit" name="checkout" value="Finalizar compra" id="checkout" />
					</form>
				</td>
				<td>${carrinhoDeCompra.total}</td>
				<td></td>
			</tr>
		</tfoot>
	</table>
</customTags:pageTemplate>