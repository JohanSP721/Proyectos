#include <stdio.h>
#include <string.h>

int main(void)
{
	unsigned int i;
	char texto[100];
	int total;

	do
	{
		scanf("%s", texto);
		total = 0;

		if (texto[0] != '-') // Si no es negativo
		{
			for (i = 0; i < strlen(texto); i++)
			{
				if (i > 0)
				{
					printf("+ "); // Operandos desde la segunda cifra
				}           
				total += (texto[i] - 48); // 48 = ASCII '0'
				printf("%c ", texto[i]);
			}
			printf("= %d", total);
		}
	} while (texto[0] == '-'); // Terminamos si es negativo

	return 0;
}