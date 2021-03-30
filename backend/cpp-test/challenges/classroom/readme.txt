- Classroom

In this challenge you'll have to read the standard input to either 
complete your classroom presence list or to consult a specific
key in the list to find out which is the student in the requested
position. The list must be sorted alphabetically.

- Expected input:
In the first line, a single integer of size N, representing the amount 
of queries, followed by N queries Q, each followed by the amount of
queries of the given type.

- Expected output:
The output corresponding to the executed queries.

- Constraints:
Input: 0 < N
Queries: 0 < Q
    1 - Insert student in the presence list
    2 - Consult student in the presence list in the given position

- Sample input:
2
1 2
Gordon Freeman
Alyx Vance
2 1
1

- Sample output:
Alyx Vance

- Sample Explanation
In the first line we tell the program we want to run two distinct
queries. In the second line we tell we want to insert a student in the 
presence list, two times. In the fifth line we tell the program we
want to query a single student in the following position in the next
line (1).

- Test cases:
All the test cases are in the 'tests' folder.
