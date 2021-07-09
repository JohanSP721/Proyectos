def mejorEstudiante( promedio, mejorPromedio, nombre, mejorEstudiante ):

	if promedio >= mejorPromedio:

		mejorPromedio = promedio
		mejorEstudiante  = nombre

	return mejorEstudiante , mejorPromedio

def peorEstudiante( promedio, peorPromedio, nombre, peorEstudiante ):

	if promedio <= peorPromedio:

		peorPromedio = promedio
		peorEstudiante = nombre

	return peorEstudiante, peorPromedio

mejor_estudiante = ' '
regular_estudiante = ' '
mejor_promedio = 0.0
regular_promedio = 5.0
promedio_curso = 0.0
N = int(input('Digite la cantidad de estudiantes del curso: '))
mat = input('Digite la materia: ')

for cantidad in range(0, N):

	nombre = input('Digite el nombres y apellidos del estudiante: ')
	nota1 = float( input( 'Digite la nota 1: ' ) )
	nota2 = float( input( 'Digite la nota 2: ' ) )
	nota3 = float( input( 'Digite la nota 3: ' ) )
	promedio = ( nota1 * 0.3 + nota2 * 0.3 + nota3 * 0.4 )
	print( 'El estudiante:', nombre )
	print( 'Obtuvo como promedio:', promedio )

	mejor_estudiante, mejor_promedio = mejorEstudiante(promedio, mejor_promedio, nombre, mejor_estudiante)

	regular_estudiante, regular_promedio = peorEstudiante(promedio, regular_promedio, nombre, regular_estudiante)

	promedio_curso = promedio_curso+promedio

promedio_curso = promedio_curso/N

print()
print('___________')
print('En la materia: ', mat)
print('El promedio del curso fue: ', promedio_curso)
print('El mejor estudiante : ', mejor_estudiante)
print('con un promedio de: ',mejor_promedio)
print('El estudiante con menor desempeño fue: ', regular_estudiante)
print('con un promedio de: ',regular_promedio)
