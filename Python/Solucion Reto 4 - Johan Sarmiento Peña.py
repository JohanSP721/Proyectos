def calcGrossSalary ( normal, extra ):

	return normal + extra

def calcDiscounts ( gross ):

	parafiscal = gross * 0.09

	health = gross * 0.04

	pension = gross * 0.04

	return parafiscal, health, pension

def calcNetSalary ( discounts, gross ):

	return gross - discounts

def calcProvisions ( gross ):

	prime = gross * 0.0833

	severance = gross * 0.0833

	interestSeverance = gross * 0.01

	holidays = gross * 0.0417

	return prime, severance, interestSeverance, holidays


workingHours = int( input() )

hourValue = int( input() )

normalHours = workingHours * hourValue if workingHours < 40 else 40 * hourValue

extraHours = int(( workingHours - 40 ) * 1.5 * hourValue) if workingHours > 40 else 0

grossSalary = calcGrossSalary( normalHours, extraHours )

parafiscal, health, pension = calcDiscounts( grossSalary )

totalDiscounts = parafiscal + health + pension

netSalary = calcNetSalary( totalDiscounts, grossSalary )

prime, severance, interestSeverance, holidays = calcProvisions( grossSalary )

print( normalHours )

print( extraHours )

print( grossSalary )

print( parafiscal )

print( health )

print( pension )

print( totalDiscounts )

print( netSalary )

print( prime )

print( severance )

print( interestSeverance )

print( holidays )


