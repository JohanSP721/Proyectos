#include <stdio.h>
#include <stdlib.h>

int Mayor(int x, int y)
{
	if (x > y)
	{
		return x;
	}
	return y;
}

int main(void)
{
	int Entero_1, Entero_2, Entero_3, MCM;
	scanf("%d %d %d", &Entero_1, &Entero_2, &Entero_3);

	MCM = Mayor(Mayor(Entero_1, Entero_2), Entero_3);

	while (MCM % Entero_1 != 0 || MCM % Entero_2 != 0 || MCM % Entero_3 != 0)
	{
		MCM++;
	}
	printf("%d", MCM);
}