function esDivisible (num, divisor)
{
	if (num % divisor == 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

var numeros = 100;
var fizz = "Fizz";
var buzz = "Buzz";

for (var i = 1; i <= 100; i++)
{
	if (esDivisible(i, 3) && esDivisible(i, 5))
	{
		document.write(fizz + buzz);
	}
	else if (esDivisible(i, 3))
	{
		document.write(fizz);  
	}
	else if (esDivisible(i, 5))
	{
		document.write(buzz);
	} 
	else
	{
		document.write(i);  
	}

	document.write("<br>");
}