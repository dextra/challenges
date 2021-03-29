- CSV

In computing, a comma-separated values (CSV) file stores tabular data 
(numbers and text) in plain text. Each line of the file is a data 
record. Each record consists of one or more fields, separated by 
commas. The use of the comma as a field separator is the source of 
the name for this file format.

In this challenge you have to parse a CSV from the standard input in
the following format:

<name>,<state>,<city>,<country>,<age>

As an example:

Renee Rice,Georgia,Atlanta,USA,56

After parsing you have to print the output in the following format:

Renee Rice is 56 years old and lives in Atlanta, Georgia.

- Expected input:
In the first line, a single integer of size N, representing the amount 
of lines to read, followed by N lines containing the user data in the 
CSV format.

- Expected output:
The pretty print version of the input data.

- Sample input:
2
Renee Rice,Georgia,Atlanta,USA,56
Agnes Brown,Arkansas,Bentonville,USA,28

- Sample output:
Renee Rice is 56 years old and lives in Atlanta, Georgia.
Agnes Brown is 28 years old and lives in Bentonville, Arkansas.

- Test cases:
All the test cases are in the 'tests' folder.
