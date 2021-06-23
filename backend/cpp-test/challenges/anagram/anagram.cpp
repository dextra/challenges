#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool is_anagram(string first_word, string second_word)
{
	if (first_word.length() != second_word.length())
		return false;

	sort(first_word.begin(), first_word.end());
	sort(second_word.begin(), second_word.end());

	if (first_word == second_word)
		return true;
	return false;
}


int main(int argc, char** argv)
{
	int n_lines = 0;

	cin >> n_lines;
	if (n_lines <= 0)
		return 1;

	string first_word, second_word;

	for (size_t i = 0; i < n_lines; i++)
	{
		cin.ignore();
		cin >> first_word >> second_word;

		if (is_anagram(first_word, second_word))
			cout << first_word << " is an anagram of " << second_word << endl;
		else
			cout << first_word << " is not an anagram of " << second_word << endl;
	}

	return 0;
}
