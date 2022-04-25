#include <stdio.h>

typedef struct {
	char* brand;
	char* model;
	char* color;
	int memory;
} smartphone_t;

void print_smartphone_configuration(smartphone_t phone) {
	printf("Your configuration:\n");
	printf("\tBrand: %s\n", phone.brand);
	printf("\tModel: %s\n", phone.model);
	printf("\tColor: %s\n", phone.color);
	printf("\tMemory: %dGB\n", phone.memory);
}

void add_additional_sd_card(smartphone_t* phone) {
	phone->memory += 128; //or (*phone).memory += 128;
	printf("Added 128GB sd card to %s.\n", phone->model);
}

int main() {
	smartphone_t phone = {"Sumsang", "Milkyway S3", "black", 16};
	print_smartphone_configuration(phone);

	add_additional_sd_card(&phone);
	print_smartphone_configuration(phone);
}