def watchList():

	archive = open( 'agenda.txt', 'r' )

	print( 'Listado de beneficiarios' )

	print( archive.read() )

	archive.close()

def readArchive():

	schedule = {}

	archive = open( 'agenda.txt', 'r' )

	listArchive = archive.readlines()

	count = 0

	name = ''
	idCard = ''
	phoneNumber = ''

	for line in listArchive:

		count += 1

		if count == 1:

			name = line.strip( '\n' )

		if count == 2:

			idCard = line.strip( '\n' )

		if count == 3:

			phoneNumber = line.strip( '\n' )

			schedule[ idCard ] = [ name, phoneNumber ]

			count = 0

			name = ''
			idCard = ''
			phoneNumber = ''

	archive.close()

	return( schedule )

def watchFilteredList( schedule ):

	print( 'Digite la letra por la que empiezan los beneficiarios:' )

	letter = input()

	print( 'Listado filtrado de beneficiarios:' )

	for key, value in schedule.items():

		if value[ 0 ][ 0 ] == letter:

			print( value[ 0 ] )
			print( key )
			print( value[ 1 ] )

def saveBeneficiary():

	archive = open( 'agenda.txt', 'a+' )

	print( 'Digite la información del beneficiario a agregar:' )

	name = input()
	idCard = input()
	phoneNumber = input()

	archive.write( name + '\n' )
	archive.write( idCard + '\n' )
	archive.write( phoneNumber + '\n' )

	print( 'El beneficiario ha sido agregado' )

	archive.close()

def searchBeneficiary( schedule ):

	print( 'Digite el nombre y apellido del beneficiario a buscar:' )

	searchName = input()

	search = False

	for key, value in schedule.items():

		if value[ 0 ] == searchName:

			print(value[ 0 ])
			print(key)
			print(value[ 1 ])

			search = True

	if search == False:

		print( 'beneficiario no encontrado' )

def eraseBeneficiary( schedule ):

	print( 'Digite la cedula del beneficiario a borrar:' )

	idCard = input()

	if idCard in schedule:

		del schedule[idCard]

		print( 'El usuario ha sido eliminado del listado' )

	else:

		print( 'beneficiario no existe en la agenda' )

		return(schedule)

def saveArchive( schedule ):

	archive = open( 'agenda.txt', 'w' )

	for key, value in schedule.items():

		archive.write( value[0] + '\n' )
		archive.write( key + '\n' )
		archive.write( value[1] + '\n' )

	archive.close()

def menu():

	print( 'Menu Principal' )
	print( '1. Ver listado' )
	print( '2. Ver listado filtrado' )
	print( '3. Agregar beneficiario' )
	print( '4. Buscar beneficiario' )
	print( '5. Borrar beneficiario' )
	print( '6. Salir' )

	option = int(input())

	if option == 1:

		watchList()

	if option == 2:

		schedule = readArchive()
		watchFilteredList(schedule)

	if option == 3:

		saveBeneficiary()

	if option == 4:

		schedule = readArchive()
		searchBeneficiary(schedule)

	if option == 5:

		schedule = readArchive()
		eraseBeneficiary(schedule)
		saveArchive(schedule)

	if option == 6:

		print( 'Hasta pronto' )
		exit(0)

	else:

		menu()

archive = open( 'agenda.txt', 'w' )
archive.close()
menu()
