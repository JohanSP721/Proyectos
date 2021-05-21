print( 'Digite la edad del estudiante: ' )
edadEstudiante = int( input() )
print( 'Digite el puntaje que el estudiante obtuvo en la prueba: ' )
puntajePrueba = int( input() )
print( 'Digite el numero de salarios minimos de ingreso familiar que recibe mensualmente el estudiante: ' )
numeroSalariosMinimos = int( input() )

if ( edadEstudiante < 0 ):
	print( 'La edad no puede ser negativa' )
	exit(1)
elif ( edadEstudiante >= 15 ):
	if ( edadEstudiante >= 15 and edadEstudiante <= 18 ):
		descuentoEdad = 25
	elif ( edadEstudiante >= 19 and edadEstudiante <= 21 ):
		descuentoEdad = 15
	elif ( edadEstudiante >= 22 and edadEstudiante <= 25 ):
		descuentoEdad = 10
	else:
		descuentoEdad = 0
elif ( edadEstudiante >= 100 ):
	print( 'La edad suministrada es demasiado grande' )
else:
	print( 'La edad del estudiante no puede ser menor que 15' )
	exit(1)

if ( numeroSalariosMinimos < 0 ):
	print( 'El numero de salarios minimos no puede ser negativo' )
	exit(1)
elif ( numeroSalariosMinimos >= 0 ):
	if ( numeroSalariosMinimos <= 1 ):
		descuentoSalarios = 30
	elif ( numeroSalariosMinimos > 1 and numeroSalariosMinimos <= 2 ):
		descuentoSalarios = 20
	elif ( numeroSalariosMinimos > 2 and numeroSalariosMinimos <= 3 ):
		descuentoSalarios = 10
	elif ( numeroSalariosMinimos > 3 and numeroSalariosMinimos <= 4 ):
		descuentoSalarios = 5
	else:
		descuentoSalarios = 0

if ( puntajePrueba < 0 ):
	print( 'El resultado de la prueba no puede ser negativo' )
	exit(1)
elif ( puntajePrueba <= 100 ):
	if ( puntajePrueba >= 80 and puntajePrueba < 86 ):
		descuentoPrueba = 30
	elif ( puntajePrueba >= 86 and puntajePrueba < 91 ):
		descuentoPrueba = 35
	elif ( puntajePrueba >= 91 and puntajePrueba < 96 ):
		descuentoPrueba = 40
	elif ( puntajePrueba >= 96 ):
		descuentoPrueba = 45
	else:
		descuentoPrueba = 0
else:
	print( 'el resultado de la prueba no puede ser mayor que 100' )
	exit(1)


descuentoTotal = descuentoEdad + descuentoSalarios + descuentoPrueba


print('un descuento por edad de:')
print(descuentoEdad, '%')
print('un descuento por resultado de prueba de:')
print(descuentoPrueba, '%')
print('un descuento por ingreso familiar de:')
print(descuentoSalarios, '%')
print('lo que produce un descuento total de:')
print(descuentoTotal, '%')