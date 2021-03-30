# C++ Test

Welcome to the Dextra hiring test for C++ developers. Please fork this repository and submit a pull request once you have finished this set of coding challenges.

This test will be about code clarity, problem solving and understanding of the C++ language. There are ten challenges that need to be solved, each one with its own constraints and test cases.

## What will be evaluated

When reviewing your code we are going to focus in the usage of the C++ idioms, usage of STL classes and functions, code consistency, clarity and coherence. If a challenge asks you to solve a problem using an algorithm and/or data structure, we want you to pick what C++ has off-the-shelf and use it. We are not looking for code implementing data structures and algorithms from the scratch.

If you want to use C++11/14/1z, Boost or another library to solve any of the tests, you are allowed to do so. Just remember this is a CMake based project and you need to take care of the newly introduced dependencies before submitting your pull request.

## Dependencies

* Bash
* CMake
* Diff
* A C++ compiler (like G++ or clang).

## Solving the tests

In the root folder there is a 'challenges' directory, containing ten challenges. Every challenge contains a 'readme.txt' file explaining what needs to be done and what are the constraints, input and output formats. You'll have to edit the '.cpp' file for each challenge and then make sure the tests cases don't fail.

## Building and running the test cases

Everything in this test is automated using CMake. You can create a shadow build folder or build it in the root folder (but this is not recommended). Here we are going to assume you are in the root folder.

#### Running CMake:

```shell
$ cmake .
```

#### Building the project:

```shell
$ make all
```

#### Running the tests cases:

```shell
$ ctest .
```

#### Running a specific test case (verbose):

```shell
$ ctest -R <test> -V
```

CTest will show you which one of the test cases failed. You are free to look at the tests cases to better understand what is required to make it pass. Don't forget to build the code before running the tests.

## Additional notes

Everything here was developed and tested in a unix-like environment. We didn't ensure it would run on Windows platforms, but if you are feeling adventurous, there is nothing preventing you to do so (but you will be on your own).
