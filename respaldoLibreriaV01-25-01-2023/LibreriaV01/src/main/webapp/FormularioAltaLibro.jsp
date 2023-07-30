<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario Alta Libro</title>
		<script src="js/validacionLibros.js"></script>
		<LINK rel="stylesheet" type="text/css" href="css/vista.css"/>
	</head>
	<body>
		<h1>Formulario Alta Libro</h1>
		<form action ="Insertar.do" method = "GET">
			<P><labeL for="ISBN">ISBN:</label>
			<input type="text" name="ISBNLibro" id="ISBN"/></p>
			
			<P><label for="Titulo">Titulo:</label>
			<input type="text" name="TitLibro" id="Titulo"/></p>
			
			<P><label for="Categoria">Categoria:</label>
			<input type="text" name="CatLibro" id="Categoria"/></p>
			
			<P><label for="Precio">Precio:</label>
			<input type="text" name="PreLibro" id="Precio"/></p>
			
			<input type="submit" value="Insertar"/>
		</form>
	</body>
</html>