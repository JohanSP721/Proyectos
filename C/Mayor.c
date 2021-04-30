#include <stdio.h>

int main(void)
{
	int entero1;
	int entero2;

	scanf("%d %d", &entero1, &entero2);

	if(entero1 > entero2)
	{
		printf("%d\n", entero1);
	}
	else
	{
		printf("%d\n", entero2);
	}
}