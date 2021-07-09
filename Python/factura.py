# Entrada

nombreProducto = input('Digite el nombre del articulo: ');
precioDeVenta = float(input('Digite el precio de venta del articulo: '));
cantidadVenta = int(input('Digite la cantidad de articulos a comprar: '));

# Proceso

precioDeVenta = precioDeVenta * cantidadVenta;

precioBruto = precioDeVenta * 1.19;

print(f'Su compra tiene un iva del 19% por lo tanto el valor facturado sera {precioBruto}')

if (precioBruto > 50000):
	precioBruto = precioBruto - (precioBruto * 0.5);
	print(f'Su compra tiene un descuento del 5% por lo tanto el precio facturado es: {precioBruto}');

# Salida
