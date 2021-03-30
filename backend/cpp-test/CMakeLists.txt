cmake_minimum_required(VERSION 2.6)
project(cpp-test)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin")

function(add_challenge _CHALLENGE_NAME)
	add_executable(${_CHALLENGE_NAME} ${_CHALLENGE_NAME}.cpp)

	set(_WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/tests)

	file(GLOB_RECURSE _INPUT_FILES ${_WORKING_DIRECTORY}/ input*.txt)

	foreach(_INPUT_FILE ${_INPUT_FILES})
		set(_FILE_COUNT "")
		string(REGEX MATCH "([0-9]+)\\.txt$" _FILE_COUNT ${_INPUT_FILE})
		string(REGEX MATCH "[0-9]+" _FILE_COUNT ${_FILE_COUNT})

		set(_TEST_COMMAND "diff -w -Z <(cat ${_WORKING_DIRECTORY}/input${_FILE_COUNT}.txt | $<TARGET_FILE:${_CHALLENGE_NAME}>) <(cat output${_FILE_COUNT}.txt)")

		add_test(NAME ${_CHALLENGE_NAME}_test_${_FILE_COUNT}
			COMMAND /bin/bash -c ${_TEST_COMMAND}
			WORKING_DIRECTORY ${_WORKING_DIRECTORY})

	endforeach()
endfunction()

enable_testing()
include(CTest)

add_subdirectory(challenges)
