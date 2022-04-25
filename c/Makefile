CFLAGS  = -std=c11 -Wall -Wextra -Wpedantic

all: blatt1 blatt2

blatt1:
	$(CC) $(CFLAGS) -c -o tree.o tree.c
	$(CC) $(CFLAGS) tree.o -lm -o tree
	$(CC) $(CFLAGS) -c -o primes.o primes.c
	$(CC) $(CFLAGS) primes.o -lm -o primes
	$(CC) $(CFLAGS) -c -o smartphone.o smartphone.c
	$(CC) $(CFLAGS) smartphone.o -lm -o smartphone
 
blatt2:
	$(CC) $(CFLAGS) -c -o anagram.o anagram.c
	$(CC) $(CFLAGS) anagram.o -lm -o anagram
	$(CC) $(CFLAGS) -c -o concat.o concat.c
	$(CC) $(CFLAGS) concat.o -lm -o concat
	$(CC) $(CFLAGS) -c -o dynamic_array.o dynamic_array.c
	$(CC) $(CFLAGS) dynamic_array.o -lm -o dynamic_array

clean:
	$(RM) tree.o tree primes.o primes smartphone.o smartphone
	$(RM) anagram.o anagram concat.o concat dynamic_array.o dynamic_array
