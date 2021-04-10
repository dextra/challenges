#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;


unsigned long fibonacci(int n, unordered_map<int, unsigned long>& memory)
{
	if (n == 0)
		return 0;
	if (n == 1 || n == 2)
		return 1;
	if (memory[n] == 0)
		memory[n] = fibonacci(n - 1, memory) + fibonacci(n - 2, memory);
	return memory[n];
}

unsigned long fibonacci(int n)
{
	unordered_map<int, unsigned long> memory;
	memory.reserve(n);
	return fibonacci(n, memory);
}



int main(int argc, char** argv)
{
	int num;
	cin >> num;
	if (num < 0)
		return 1;
	cout << fibonacci(num) << endl;
	return 0;
}
