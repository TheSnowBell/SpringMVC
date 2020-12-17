<%@attribute name="title" required="true"%>
<%@attribute name="bodyClass" required="true"%>
<%@attribute name="extraScripts" fragment="true"%>

<!doctype html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="pt">
<![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8" lang="pt">
<![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="pt"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="pt">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>${title}</title>
</head>
<body class="${bodyClass}">

	<jsp:doBody />

	<jsp:invoke fragment="extraScripts" />
</body>
</html>