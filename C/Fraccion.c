#include <stdio.h>

int main(void)
{
	double decimal;
	int  i = 1, j;
	double resultado;
	int salir = 1;

	int numerador, denominador;
	scanf("%lf", &resultado);
	while (salir)
	{
		for (j = 1; j <= 10000; j++)
		{
			decimal = (double)i / j;
			
			if ((resultado == decimal))
			{
				numerador = i;
				denominador = j;
				salir = 0;
			}
		}
		i++;
	}
	printf("%d/%d\n", numerador, denominador);
	return 0;
}