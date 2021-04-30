#include <iostream>
#include <string>
using namespace std;

int main()
{
	unsigned int i;
	string texto;
	int total;

	do
	{
		cin >> texto;
		total = 0;

		if (texto[0] != '-') // Si no es negativo
		{
			for (i = 0; i < texto.length(); i++)
			{
				if (i > 0)
					cout << "+ ";       // Operandos desde la segunda cifra
				total += texto[i] - 48; // 48 = ASCII '0'
				cout << texto[i] << " ";
			}
			cout << "= " << total;
		}
	} while (texto[0] == '-'); // Terminamos si es negativo

	return 0;
}