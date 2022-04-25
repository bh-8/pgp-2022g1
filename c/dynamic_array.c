#include <stdio.h>
#include <stdlib.h>

typedef struct {
	char* array; //stores string
	int numElems; //stores amount of elements
	int size; //stores amount of total space in array
	int reallocs; //stores how often memory got reallocated
} Dyn_array_t;

Dyn_array_t* initArray(int desSize) {
	//if requested size is too small
	if(desSize < 1) {
		printf("Error: Can not initialize Array: array length has to be at least 1!\n");
		return NULL;
	}
	
	//allocate memory for struct
	Dyn_array_t* array = (Dyn_array_t*)malloc(sizeof(Dyn_array_t));
	if(!array) {
		printf("Error: Could not initialize Array: malloc error!\n");
		return NULL;
	} else {
		//allocate memory for char array
		array->array = (char*)calloc(desSize, sizeof(char));
		
		//initialize
		array->numElems = 0;
		array->size = desSize;
		array->reallocs = 0;
		
		//return pointer to struct
		return array;
	}
}

void destroyArray(Dyn_array_t* array) {
	if(array != NULL) {
		free(array->array);
		free(array);
		array = NULL;
	} else {
		printf("Error: Can not free memory: array is NULL (not initialized)!\n");
	}
}

void insert(Dyn_array_t* array, char elem) {
	if(array != NULL) {
		//if not enough memory available
		if(array->numElems >= array->size) {
			//double size
			array->size *= 2;
			
			//get more memory
			array->array = realloc(array->array, array->size);
			
			//count reallocs
			array->reallocs++;
		}
		//append next char
		array->array[array->numElems] = elem;
		
		//increase element count
		array->numElems++;
	} else {
		printf("Error: Can not insert element: array is NULL (not initialized)!\n");
	}
}

void printArray(Dyn_array_t* array) {
	if(array != NULL) {
		printf("array='%s', numElems=%d, size=%d, reallocs=%d\n", array->array, array->numElems, array->size, array->reallocs);
	} else {
		printf("Error: Can not print array: array is NULL (not initialized)!\n");
	}
}

void printArrayAsString(Dyn_array_t* array) {
	if(array != NULL) {
		printf("%s\n", array->array);
	} else {
		printf("Error: Can not print array: array is NULL (not initialized)!\n");
	}
}

int main() {
	Dyn_array_t* arr = initArray(1);
	
	insert(arr, 'A');
	insert(arr, 'B');
	insert(arr, 'C');
	insert(arr, 'D');
	insert(arr, 'E');
	insert(arr, 'F');
	insert(arr, 'G');
	insert(arr, 'H');
	insert(arr, 'I');
	
	printArray(arr);
	printArrayAsString(arr);
	
	destroyArray(arr);
	
	return EXIT_SUCCESS;
}