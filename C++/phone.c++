#include <iostream>
#include <string>
#include <time.h>
#include <stdlib.h>
using namespace std;

char *create_phone_number(char phnum[15], char nums[10])
{
	srand(time(NULL));
	phnum[0] = 40;
	for (int i = 1; i < 4; i++)
	{
		int j = rand() % 10;
		phnum[i] = nums[j];
	}
	phnum[4] = 41;
	phnum[5] = 32;
	for (int i = 6; i < 9; i++)
	{
		int j = rand() % 10;
		phnum[i] = nums[j];
	}
	phnum[9] = 45;
	for (int i = 10; i < 14; i++)
	{
		int j = rand() % 10;
		phnum[i] = nums[j];
	}
	return phnum;
}

int main(void)
{
	char phnum[15] = "\0\0\0\0\0\0\0\0\0\0\0\0\0\0";
	char nums[10];
	cin >> nums;
	create_phone_number(phnum, nums);
	cout << phnum;
}