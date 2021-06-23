#include <iostream>
#include <string>
#include <vector>

using namespace std;

std::string& ltrim(std::string& str, const std::string& chars = "\t\n\v\f\r ")
{
	str.erase(0, str.find_first_not_of(chars));
	return str;
}

std::string& rtrim(std::string& str, const std::string& chars = "\t\n\v\f\r ")
{
	str.erase(str.find_last_not_of(chars) + 1);
	return str;
}

std::string& trim(std::string& str, const std::string& chars = "\t\n\v\f\r ")
{
	return ltrim(rtrim(str, chars), chars);
}


int main(int argc, char** argv)
{
	int n_lines;
	cin >> n_lines;

	if (n_lines < 0)
		return 1;

	int amount = 0;
	int total = 0;
	string type;

	for (size_t i = 0; i < n_lines; i++)
	{
		cin >> ws >> amount >> type;
		trim(type);
		if (type == "dirty")
			total += amount;
	}

	if (total > 0)
		cout << "There are " << total << " dirty bills." << endl;
	else
		cout << "There are no dirty bills." << endl;
	return 0;
}
