#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void ordenamientoBurbuja (char four[])
{
	char temp;

	for(int i = 0; i < 3; i++)
	{
		for(int j = i + 1; j < 4; j++)
		{
			if(four[j] > four[i])
			{
				temp = four[i];
				four[i] = four[j];
				four[j] = temp;
			}
		}
	}
}

float evaluarResta (char fourA[])
{
	char fourD[4] = {0,0,0,0};
	float resta;
	fourD[0] = fourA[3];
	fourD[1] = fourA[2];
	fourD[2] = fourA[1];
	fourD[3] = fourA[0];

	resta = atof(fourA) - atof(fourD);

	return resta;
}

float numeroIteraciones (float numero)
{
	int iteración = 0;
	float resta = numero;
	char four[4];

	float q = (int)(resta / 1111);
	float z = resta - (1111 * q);

	if (z == 0)
	{
		iteración = 8;
	}
	else
	{
		while(resta != 6174)
		{
			itoa(resta, four, 10);
			ordenamientoBurbuja(four);
			resta = evaluarResta(four);
			if (resta == 999)
			{
				resta = 6174;
				iteración = 5;
			}
			else
			{
				iteración++;
			}
		}
	}

	return iteración;
}

int main(void)
{
	int casos, iteraciones, numero, i;
	char four[4];

	scanf("%d", &casos);

	for(i = 0; i < casos; i++)
	{
		scanf("%d", &numero);
		iteraciones = numeroIteraciones(numero);
		printf("%d", iteraciones);
	}
}
