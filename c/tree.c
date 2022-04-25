#include <stdio.h>

void print_tree_char(int height, char sym) {
	//Loop through tree height to build leaves
	for(int i = 0, _blanks = height - 1; i < height; i++, _blanks--) {
		//Print blanks
		for(int j = 0; j < _blanks; j++) {
			putchar(' ');
		}
		//Print leaves
		for(int j = 0, _treechars = i * 2 + 1; j < _treechars; j++) {
			putchar(sym);
		}
		//Next line
		putchar('\n');
	}
	//Print blanks+stem
	for(int i = 0; i < height - 1; i++) {
		putchar(' ');
	}
	printf("*\n");
}

void print_tree(int height) {
	print_tree_char(height, '*');
}

int main() {
	print_tree(5);
	print_tree_char(5, 'o');
}