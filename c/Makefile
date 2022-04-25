CFLAGS  = -std=c11 -Wall -Wextra -Wpedantic

all: blatt1

blatt1:
	$(CC) $(CFLAGS) -c -o tree.o tree.c
	$(CC) $(CFLAGS) tree.o -lm -o tree
	$(CC) $(CFLAGS) -c -o primes.o primes.c
	$(CC) $(CFLAGS) primes.o -lm -o primes
	$(CC) $(CFLAGS) -c -o smartphone.o smartphone.c
	$(CC) $(CFLAGS) smartphone.o -lm -o smartphone

clean:
	$(RM) tree.o tree primes.o primes smartphone.o smartphone
