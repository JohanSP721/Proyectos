nombreEmpleado = input('Digite el nombre del empleado/a: ');
salarioEmpleado = float(input('Digite el salario basico del empleado/a: '));

salarioEmpleadoMenosAportes = salarioEmpleado - ((salarioEmpleado * 0.04) * 2);

print(f'El empleado {nombreEmpleado} recibirá un sueldo de {salarioEmpleadoMenosAportes}');

if( salarioEmpleado <= 908526 * 2 ):
	salarioEmpleadoMenosAportes += 106454;
	print(f'El empleado {nombreEmpleado} tiene derecho a subsidio de transporte por lo que su sueldo sera {salarioEmpleadoMenosAportes}');
