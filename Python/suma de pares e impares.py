def sumPairs(num):

	cantPairs = 0
	sumTotalPairs = 0

	for i in range( 1, num + 1 ):
		if( i % 2 == 0 ):

			cantPairs = cantPairs + 1

			sumTotalPairs = sumTotalPairs + i

	return cantPairs, sumTotalPairs

def sumOdd(num):

	cantOdd = 0
	sumTotalOdd = 0

	for i in range( 1, num + 1 ):
		if( i % 2 != 0 ):

			cantOdd = cantOdd + 1

			sumTotalOdd = sumTotalOdd + i

	return cantOdd, sumTotalOdd

num = int(input('Digite la cantidad de números: '))

cantPairsVar, sumPairsVar = sumPairs(num)
print( 'los números pares fueron', cantPairsVar, 'lo que suma:', sumPairsVar )

cantOddVar, sumOddVar = sumOdd(num)
print( 'los números impares fueron', cantOddVar, 'lo que suma:', sumOddVar )
