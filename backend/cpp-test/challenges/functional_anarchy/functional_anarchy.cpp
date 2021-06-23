#include <iostream>
#include <algorithm>
#include <iterator>
#include <numeric>
#include <set>

using namespace std;

int main(int argc, char** argv)
{
	int n_lines = 0;

	cin >> n_lines;
	
	if (n_lines <= 0)
		return 1;

	multiset<int> numbers;

	for (size_t i = 0; i < n_lines; i++)
	{
		int number;
		cin >> ws >> number;
		numbers.insert(number);
	}

	for (const auto number : numbers)
		cout << number << endl;

	return 0;
}
