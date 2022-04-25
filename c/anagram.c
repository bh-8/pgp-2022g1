#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int is_anagram(char* word, char* compared) {
	//check string length
	if(strlen(word) != strlen(compared)) {
		return 0;
	}
	
	//length
	size_t length = strlen(compared);
	
	//allocate memory to store which character already used
	int* used = calloc(length, sizeof(int));
	//printf("Allocated %zu bytes at %p\n", length, (void*)used);
	
	//set all indexes to 0
	memset(used, 0, length);
	
	//loop through word
	for(size_t i = 0; i < length; i++) {
		//could found position:
		int foundCharPosition = 0;
		
		//search for character
		for(size_t j = 0; j < length; j++) {
			//if character found and not used already
			if(word[i] == compared[j] && used[j] == 0) {
				//printf("Index %zu is equal to index %zu: position %zu set to 1.\n", i, j, j);
				
				//set character to used
				used[j] = 1;
				
				//set to found
				foundCharPosition = 1;
				break;
			}
		}
		
		//if not found
		if(foundCharPosition == 0) {
			free(used);
			return 0;
		}
	}
	
	free(used);
	
	return 1;
}

int main() {
	printf("%d\n", is_anagram("mehl", "helm"));
	printf("%d\n", is_anagram("boeing", "airbus"));
	printf("%d\n", is_anagram("test", "tfes"));
	printf("%d\n", is_anagram("test", "ttes"));
	return EXIT_SUCCESS;
}