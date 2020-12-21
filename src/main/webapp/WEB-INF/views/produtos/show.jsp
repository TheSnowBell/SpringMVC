<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="customTags"%>

<customTags:pageTemplate bodyClass="" title="Mostrar">

	<header id="layout-header">
		<div>
			<div id="header-content">
				<nav id="main-nav">
					<ul>

						<li><a href="${spring:mvcUrl('CDCC#itens').build()}" rel="nofollow"> <spring:message code="carrinho" arguments="${carrinhoDeCompra.quantidadeTotalDeItensNoCarrinho}" /> </a></li>

					</ul>
				</nav>
			</div>
		</div>
	</header>

	<article id="${produto.titulo}">
		<header id="produto-highlight">
			<div id="produto-overview">
				<img itemprop="image" width="280px" height="395px" src=''
					alt="${produto.titulo}">
				<h1 itemprop="name">${produto.titulo}</h1>
				<p>
					<span> ${produto.titulo} </span>
				</p>

				<p itemprop="description">
					${produto.descricao} Veja o <a
						href="<c:url value='/${produto.summaryPath}'/>" target="_blank">sumário</a>
					completo do livro!
				</p>
			</div>
		</header>

		<section>
			<form:form servletRelativeAction="/carrinhoDeCompra"  >

				<input type="hidden" value="${produto.id}" name="produtoId" />
				<ul id="variants">
					<c:forEach items="${produto.precos}" var="preco">
						<li><input type="radio" name="bookType"
							id="${produto.id}-${preco.bookType}" value="${preco.bookType}"
							${preco.bookType.name() == 'COMBO' ? 'checked' : ''}> <label
							for="${produto.id}-${preco.bookType}"> ${preco.bookType}
						</label>
							<p>${preco.valor}</p></li>
					</c:forEach>

				</ul>
				
					<spring:message code="show.submit" var="submit" />
					<input name="submit" type="submit" alt="Compre agora"
					title="Compre agora '${produto.titulo}'!" value="${submit}" />

			</form:form>
		</section>

		<div class="container">

			<section itemprop="author">
				<h2 itemprop="name">${produto.titulo}</h2>
				<span itemprop="description"> ${produto.descricao} </span>
			</section>

			<section>
				<h2> <spring:message code="dadosLivro" /> </h2>
				<p>
					<spring:message code="paginas" /> <span itemprop="numberOfPages">${produto.paginas}</span>
				</p>

				<p></p>
			</section>
		</div>

	</article>

</customTags:pageTemplate>