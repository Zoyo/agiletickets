<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Lista de Espet�culos</title>
	</head>
	<body>
		
		<h2>Valor da compra</h2>
		<form action="calculaValorTotal" method="get">
			<label for="valorUnitario">Valor unit�rio da Sess�o:</label>
			<input type="text" name="valorUnitario" id="valorUnitario"/>
			<label for="quantidade">Quantidade:</label>
			<input type="text" name="quantidade" id="quantidade"/>
			
			<input type="submit" value="Calcular"/>
		</form>
		
		<c:if test="${not empty resultado}">
			<p id="message">Valor a ser pago:${resultado}</p>
		</c:if>
	</body>
</html>