/**
 *	
 */
 function validacion()
{
	var n1, n2 ,n3,n4;
		n1= document.getElementById("ISBN").value;
		n2= document.getElementById("Titulo").value;
		n3= document.getElementById("Categoria").value;
		n4= document.getElementById("Precio").value;
		if(n1=="" || n2==""|| n3==""|| n4=="")
		{
			alert("Los campos no pueden quedar vacios");
		}
		else
		{
			document.forms[0].action = "Insertar.do?ISBN="+n1+"&Titulo="+n2+"&Categoria="+n3+"&Precio="+n4;
			document.forms[0].method = "post"; 
			document.forms[0].submit();
		}
}