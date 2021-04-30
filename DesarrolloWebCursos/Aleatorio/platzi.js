function aleatorio (min, maxi)
{
	var resultado;
	resultado = Math.floor(Math.random() * (maxi - min + 1)) + min;

	return resultado;
}

function dibujar ()
{
	if (fondo.cargaOk)
	{
		papel.drawImage(fondo.objeto, 0, 0);
	}

	if (vaca.cargaOk)
	{
		papel.drawImage(vaca.objeto, xVaca, yVaca); 
	}

	if (cerdo.cargaOk)
	{
		papel.drawImage(cerdo.objeto, xCerdo, yCerdo); 
	}

	if (pollo.cargaOk)
	{
		papel.drawImage(pollo.objeto, xPollo, yPollo); 
	}
}

function mover (evento)
{
	switch (evento.keyCode)
	{
		case teclas.UP:
			yVaca = yVaca - movimiento;
			dibujar();
			break;
		case teclas.DOWN:
			yVaca = yVaca + movimiento;
			dibujar();
			break;
		case teclas.LEFTH:
			xVaca = xVaca - movimiento;
			dibujar();
			break;
		case teclas.RIGHT:
			xVaca = xVaca + movimiento;
			dibujar();
			break;
		case wasd.W:
			yCerdo = yCerdo - movimiento;
			dibujar();
			break;
		case wasd.S:
			yCerdo = yCerdo + movimiento;
			dibujar();
			break;
		case wasd.A:
			xCerdo = xCerdo - movimiento;
			dibujar();
			break;
		case wasd.D:
			xCerdo = xCerdo + movimiento;
			dibujar();
			break;
		case ijkl.I:
			yPollo = yPollo - movimiento;
			dibujar();
			break;
		case ijkl.K:
			yPollo = yPollo + movimiento;
			dibujar();
			break;
		case ijkl.J:
			xPollo = xPollo - movimiento;
			dibujar();
			break;
		case ijkl.L:
			xPollo = xPollo + movimiento;
			dibujar();
			break;
	}
}

function cargarFondo ()
{
	fondo.cargaOk = true;
	dibujar();
}

function cargarVacas ()
{
	vaca.cargaOk = true;
	dibujar();
}

function cargarCerdos ()
{
	cerdo.cargaOk = true;
	dibujar();
}

function cargarPollos ()
{
	pollo.cargaOk = true;
	dibujar();
}

var fondo = {
	url: "tile.png",
	cargaOk: false
};

var vaca = {
	url: "vaca.png",
	cargaOk: false
};

var cerdo = {
	url: "cerdo.png",
	cargaOk: false
};

var pollo = {
	url: "pollo.png",
	cargaOk: false
};

var teclas = {
	LEFTH: 37,
	UP: 38,
	RIGHT: 39,
	DOWN: 40,
};

var wasd = {
	W: 87,
	A: 65,
	S: 83,
	D: 68
};

var ijkl = {
	I: 73,
	J: 74,
	K: 75,
	L: 76
};

var vP = document.getElementById("villaPlatzi");
var papel = vP.getContext("2d");
var alto = parseInt(vP.height);
var movimiento = 5;

fondo.objeto = new Image();
fondo.objeto.src = fondo.url;
fondo.objeto.addEventListener("load", cargarFondo);

vaca.objeto = new Image();
vaca.objeto.src = vaca.url;
vaca.objeto.addEventListener("load", cargarVacas);
var xVaca = aleatorio(0, (alto - 80));
var yVaca = aleatorio(0, (alto - 80));

cerdo.objeto = new Image();
cerdo.objeto.src = cerdo.url;
cerdo.objeto.addEventListener("load", cargarCerdos);
var xCerdo = aleatorio(0, (alto - 80));
var yCerdo = aleatorio(0, (alto - 80));

pollo.objeto = new Image();
pollo.objeto.src = pollo.url;
pollo.objeto.addEventListener("load", cargarPollos);
var xPollo = aleatorio(0, (alto - 80));
var yPollo = aleatorio(0, (alto - 80));

document.addEventListener("keydown", mover);
