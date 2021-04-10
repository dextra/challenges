#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

void print_stair(int size)
{
	for (size_t i = 1; i <= size; i++)
	{
		cout << setfill(' ') << setw(size - i) << "";
		cout << setfill('#') << setw(i) << "";
		cout << endl;
	}
}

int main(int argc, char** argv)
{
	int n = 0;
	cin >> n;

	if (n <= 0)
	{
		cout << "Error." << endl;
		return 1;
	}

	print_stair(n);
	return 0;
}
