<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html class="no-js" lang="pt">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<title>${produto.titulo}</title>
</head>
<body class="produto">

	<header id="layout-header">
		<div >
			<div id="header-content">
				<nav id="main-nav">
					<ul>

						<li>
							<a href="" rel="nofollow">Seu carrinho (${carrinhoDeCompra.quantidadeTotalDeItensNoCarrinho}) </a>
						</li>

					</ul>
				</nav>
			</div>
		</div>
	</header>

	<article id="${produto.titulo}">
		<header id="produto-highlight">
			<div id="produto-overview">
				<img itemprop="image" width="280px" height="395px" src='' alt="${produto.titulo}">
				<h1 itemprop="name">${produto.titulo}</h1>
				<p>
					<span> ${produto.titulo} </span>
				</p>

				<p itemprop="description">
					${produto.descricao} Veja o <a href="<c:url value='/${produto.summaryPath}'/>" target="_blank">sumário</a>
					completo do livro!
				</p>
			</div>
		</header>


		<section>
			<form action="<c:url value="/shopping"/>" method="post">
				<input type="hidden" value="${produto.id}" name="produtoId" />
				<ul id="variants" >
					<c:forEach items="${produto.precos}" var="preco">
						<li>
							<input type="radio" name="bookType" id="${produto.id}-${preco.bookType}" value="${preco.bookType}" ${preco.bookType.name() == 'COMBO' ? 'checked' : ''}> 
							<label for="${produto.id}-${preco.bookType}"> ${preco.bookType} </label>
							<p>${preco.valor}</p>
						</li>
					</c:forEach>

				</ul>

				<input type="submit" alt="Compre agora" title="Compre agora '${produto.titulo}'!" value="comprar" />
			</form>

		</section>

		<div class="container">

			<section itemprop="author">
				<h2 itemprop="name">${produto.titulo}</h2>
				<span itemprop="description">
					${produto.descricao}
				</span>
			</section>

			<section>
				<h2>Dados do livro:</h2>
				<p>
					Número de paginas: <span itemprop="numberOfPages">${produto.paginas}</span>
				</p>

				<p></p>
			</section>
		</div>

	</article>

</body>
</html>