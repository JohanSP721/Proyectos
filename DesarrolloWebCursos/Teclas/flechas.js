function dibujarLinea (color, xInicial, yInicial, xFinal, yFinal, lienzo)
{
	lienzo.beginPath();
	lienzo.strokeStyle = color;
	lienzo.lineWidth = 3;
	lienzo.moveTo(xInicial, yInicial);
	lienzo.lineTo(xFinal, yFinal);
	lienzo.stroke();
	lienzo.closePath();
}

function dibujarTeclado (evento)
{
	var colorcito = "blue";
	var movimiento = 5;

	switch (evento.keyCode)
	{
		case teclas.UP:
			dibujarLinea(colorcito, x, y, x, y - movimiento, papel);
			y = y - movimiento;
			break;
		case teclas.DOWN:
			dibujarLinea(colorcito, x, y, x, y + movimiento, papel);
			y = y + movimiento;
			break;
		case teclas.LEFTH:
			dibujarLinea(colorcito, x, y, x - movimiento, y, papel);
			x = x - movimiento;
			break;
		case teclas.RIGHT:
			dibujarLinea(colorcito, x, y, x + movimiento, y, papel);
			x = x + movimiento;
			break;
	}
}

var teclas = {
	LEFTH: 37,
	UP: 38,
	RIGHT: 39,
	DOWN: 40,
};

document.addEventListener("keydown", dibujarTeclado);

var cuadrito = document.getElementById("areaDeDibujo");
var papel = cuadrito.getContext("2d");
var x = 100;
var y = 100;

dibujarLinea("red", x - 1, y - 1, x + 1, y + 1, papel);