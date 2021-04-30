#include <stdio.h>

int factoresPrimos(int n)
{
	int i = 2;
	 
	while( n >= i )
	 {            
		while( n % i == 0 ) 
		{
			printf("%d ", i);   
			n = n / i;    
		}
		i++;
	 }
}

int main(void) 
{
	 int casos, i;
	 
	 scanf("%d", &casos);
	 
	 for(int j = 0; j < casos; j++)
	 {
		  scanf("%d", &i);
		  printf("%d = ", i);
		  factoresPrimos(i);
	 }
}
