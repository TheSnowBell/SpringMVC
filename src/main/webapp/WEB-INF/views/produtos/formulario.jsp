<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>

	<form method="post" action="<c:url value="/produtos" />" >
		<div>
			<label for="titulo">Titulo</label> <input type="text" name="titulo"
				id="titulo" />
		</div>
		<div>
			<label for="descricao">Descrição</label>
			<textarea rows="10" cols="20" name="descricao" id="descricao"></textarea>
		</div>
		<div>
			<label for="paginas">Número de paginas</label> <input type="text"
				name="paginas" id="paginas" />
		</div>
		<div>
			<input type="submit" value="Enviar">
		</div>
	</form>

</body>
</html>