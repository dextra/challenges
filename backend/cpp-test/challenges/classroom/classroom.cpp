#include <iostream>
#include <algorithm>
#include <string>
#include <map>
#include <list>
#include <vector>
#include <set>

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
	int n_queries, query_type, n_entries;
	cin >> n_queries;
	if (n_queries <= 0)
		return 1;

	set<string> presence_list;

	for (size_t i = 0; i < n_queries; i++)
	{
		cin >> ws >> query_type >> n_entries;
		if (query_type <= 0 || query_type > 2 || n_entries <= 0)
			continue;

		if (query_type == 1)
		{
			string student;
			for (size_t j = 0; j < n_entries; j++)
			{
				getline(cin >> ws, student);
				trim(student);
				presence_list.insert(student);
			}
		}
		else
		{
			int order;
			for (size_t j = 0; j < n_entries; j++)
			{
				cin >> ws >> order;
				if (order > presence_list.size() || order <= 0)
					continue;
				
				string student = *next(presence_list.begin(), (order - 1));
				cout << student << endl;
			}
		}
	}

	return 0;
}
