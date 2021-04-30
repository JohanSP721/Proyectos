function dibujarLinea (color, xInicial, yInicial, xFinal, yFinal)
{
	lienzo.beginPath();
	lienzo.strokeStyle = color;
	lienzo.moveTo(xInicial, yInicial);
	lienzo.lineTo(xFinal, yFinal);
	lienzo.stroke();
	lienzo.closePath();
}

function dibujoPorClick()
{
	var lineas = parseInt(texto.value);
	var l = 0;
	var yI, xF;
	var espacio = ancho / lineas;

	for (l = 0; l < lineas; l++)
	{
		yI = espacio * l;
		xF = espacio * (l + 1);

		dibujarLinea("#AAF", 0, yI, xF, 300);
	}

	dibujarLinea("blue", 1, (ancho - 1), 1, 1);
	dibujarLinea("blue", 1, (ancho - 1), (ancho - 1), (ancho - 1));
}

var texto = document.getElementById("textoLinea");
var boton = document.getElementById("boton");
boton.addEventListener("click", dibujoPorClick);

var d = document.getElementById("dibujito");
var lienzo = d.getContext("2d");
var ancho = d.width;