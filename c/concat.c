#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* concat(char* string1, char* string2){
	size_t s1 = strlen(string1); //first string length
	size_t s2 = strlen(string2); //second string length
	
	//allocate memory for resulting string
	char* returnStr = calloc(s1 + s2, sizeof(char));
	
	//copy first string
	memcpy(returnStr, string1, s1);
	
	//copy second string
	memcpy(returnStr + s1, string2, s2);
	
	return returnStr;
}

int main() {
	char* test1 = "ABC";
	char* test2 = "DEFGHI";
	char* concatenated = concat(test1, test2);
	
	printf("%s", concat(concatenated, "\n"));
	return EXIT_SUCCESS;
}