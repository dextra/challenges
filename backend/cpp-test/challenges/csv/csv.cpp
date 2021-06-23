#include <iostream>
#include <algorithm>
#include <sstream>
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

vector<string> read_csv_line(const string& line)
{
	stringstream s(line);
	string element;
	vector<string> elements;
	while (getline(s >> ws, element, ','))
	{
		trim(element);
		elements.push_back(element);
	}

	return elements;
}

int main(int argc, char** argv)
{

	int n;
	cin >> n;
	if (n <= 0)
		return 1;
	string line;
	for (size_t i = 0; i < n; i++)
	{
		getline(cin >> ws, line);
		auto record = read_csv_line(line);
		if (record.size() == 5)
			cout << record[0] << " is " << record[4] << " years old and lives in " << record[2] << ", " << record[1] << '.' << endl;
	}

	return 0;
}
