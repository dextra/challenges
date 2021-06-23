#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool is_palindrome(string word)
{
	string rword = string(word);
	reverse(rword.begin(), rword.end());
	return rword == word;
}


int main(int argc, char** argv)
{
	int number;
	cin >> number;
	if (number < 1)
		return 1;

	string word;

	for (size_t i = 0; i < number; i++)
	{
		cin >> ws >> word;
		cout << word;
		if (is_palindrome(word))
		{
			cout << " is palindrome";
		}
		else
		{
			cout << " is not palindrome";
		}
		cout << endl;
	}
	return 0;
}
