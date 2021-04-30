var imágenes = [];
imágenes[ "Cauchin" ] = "vaca.png";
imágenes[ "Pokacho" ] = "pollo.png";
imágenes[ "Tocinauro" ] = "cerdo.png";

var colección = [];
colección.push(new Pakiman("Cauchin", 100, 30));
colección.push(new Pakiman("Pokacho", 80, 50));
colección.push(new Pakiman("Tocinauro", 120, 40));

for (var freddito of colección)
{
	freddito.mostrar();
}

for (var x in colección[ 0 ])
{
	console.log(x);
}