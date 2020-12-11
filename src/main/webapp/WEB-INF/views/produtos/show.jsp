<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="pt"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="pt"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="pt"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="pt">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<title>${produto.titulo}</title>
</head>
<body class="produto">

	<header id="layout-header">
		<div class="clearfix container">
			<a href="/" id="logo"> </a>
			<div id="header-content">
				<nav id="main-nav">
					<ul class="clearfix">

						<li><a href=""
							rel="nofollow">Seu carrinho (${carrinhoDeCompra.quantidadeTotalDeItensNoCarrinho}) </a></li>

					</ul>
				</nav>
			</div>
		</div>
	</header>

	<article id="${produto.titulo}" itemscope
		itemtype="http://schema.org/Book">
		<header id="produto-highlight" class="clearfix">
			<div id="produto-overview" class="container">
				<img itemprop="image" width="280px" height="395px" src=''
					class="produto-featured-image" alt="${produto.titulo}">
				<h1 class="produto-title" itemprop="name">${produto.titulo}</h1>
				<p class="produto-author">
					<span class="produto-author-link"> ${produto.titulo} </span>
				</p>

				<p itemprop="description" class="book-description">
					${produto.descricao} Veja o <a
						href="<c:url value='/${produto.summaryPath}'/>" target="_blank">sumário</a>
					completo do livro!
				</p>
			</div>
		</header>


		<section class="buy-options clearfix">
			<form action="<c:url value="/shopping"/>" method="post"
				class="container">
				<input type="hidden" value="${produto.id}" name="produtoId" />
				<ul id="variants" class="clearfix">
					<c:forEach items="${produto.precos}" var="preco">
						<li class="buy-option"><input type="radio" name="bookType"
							class="variant-radio" id="${produto.id}-${preco.bookType}"
							value="${preco.bookType}"
							${preco.bookType.name() == 'COMBO' ? 'checked' : ''}> <label
							class="variant-label" for="${produto.id}-${preco.bookType}">
								${preco.bookType} </label>
							<p class="variant-preco">${preco.valor}</p></li>
					</c:forEach>

				</ul>

				<input type="submit" class="submit-image icon-basket-alt"
					alt="Compre agora" title="Compre agora '${produto.titulo}'!"
					value="comprar" />

			</form>

		</section>

		<div class="container">

			<section class="author produto-detail" itemprop="author" itemscope
				itemtype="http://schema.org/Person">
				<h2 class="section-title" itemprop="name">${produto.titulo}</h2>
				<span itemprop="description">

					<p class="book-description">${produto.descricao}</p>

				</span>
			</section>

			<section class="data produto-detail">
				<h2 class="section-title">Dados do livro:</h2>
				<p>
					Número de paginas: <span itemprop="numberOfPages">${produto.paginas}</span>
				</p>


				<p></p>
				<p>
					Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta
						uma errata</a>
				</p>
			</section>
		</div>


	</article>

</body>
</html>