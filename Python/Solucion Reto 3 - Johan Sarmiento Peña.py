totalDays = 0
daysErrorLessThan5 = 0
daysErrorHigherThan35= 0
daysErrorOutOf5And35 = 0
sumTempMax = 0
sumTempMin = 0

while True:

	tempMax = int( input( 'digite la temperatura maxima registrada en el dia: ' ) )
	tempMin = int( input( 'digite la temperatura minima registrada en el dia: ' ) )

	if(tempMax == 0 and tempMin == 0):

		break

	totalDays = totalDays + 1

	if( tempMax > 35 and tempMin < 5 ):

		daysErrorOutOf5And35 = daysErrorOutOf5And35 + 1

	elif( tempMax < 5 or tempMin < 5 ):

		daysErrorLessThan5 = daysErrorLessThan5 + 1

	elif( tempMax > 35 or tempMin > 35 ):

		daysErrorHigherThan35 = daysErrorHigherThan35 + 1

	else:

		sumTempMax = sumTempMax + tempMax

		sumTempMin = sumTempMin + tempMin

daysWithError = daysErrorLessThan5 + daysErrorHigherThan35 + daysErrorOutOf5And35

goodDays = totalDays - daysWithError

avgTempMax = 0 if goodDays == 0 else sumTempMax / goodDays
avgTempMin = 0 if goodDays == 0 else sumTempMin / goodDays

percentDaysWithError = daysWithError * 100 / totalDays

print( totalDays )
print( daysWithError )
print( daysErrorLessThan5 )
print( daysErrorHigherThan35 )
print( daysErrorOutOf5And35 )
print( avgTempMax )
print( avgTempMin )
print( percentDaysWithError )
