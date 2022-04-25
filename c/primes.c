#include <stdio.h>
#include <math.h>

int is_prime(int num) {
	if(num < 2) return 0;
	
	int isPrime = 1;
	//Count from 2 to num
	for(int i = 2; i < num; i++) {
		//If num can be devided by i, it's not a prime number!
		if(num % i == 0) {
			isPrime = 0;
			break;
		}
	}
	//If num can not be devided by i, it's a prime number!
	return isPrime;
}

int calculate_nth_prime_number(int n) {
	if(n < 1) return -1;
	
	int nthPrime;
	//Count up until n prime numbers are found
	for(int i = 0, primesFound = 0; primesFound != n; i++) {
		if(is_prime(i)) {
			primesFound++; //Increase prime counter
			nthPrime = i; //Store last found prime number
		}
	}
	return nthPrime;
}

int main() {
	is_prime(1); // 0
	is_prime(2); // 1
	is_prime(3); // 1
	
	//Debug print
	for(int i = 0; i < 50; i++) {
		printf("Is %d prime number? --> %d\n", i, is_prime(i));
	}

	calculate_nth_prime_number(5); // 11
	
	//Debug print
	for(int i = 1; i < 16; i++) {
		printf("%d. prime: %d\n", i, calculate_nth_prime_number(i));
	}
}