cantElements = int( input( 'ingrese la cantidad de números que quiere en la lista: ' ) )

numbers = []

for i in range(1, cantElements + 1):

	number = float( input( f'ingrese el numero {i}: ' ) )

	numbers.append(number)


print( numbers )
