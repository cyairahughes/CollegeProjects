#include "p1-support.h"
#include <stdio.h>
#include <string.h>

////////////////////////////////////////////////////////////////////////
//
//  File          	: p1support.c
//  Description    	: This is a set of general-purpose utility functions 
//					we use for the 257 project #1.
//  Author					:Cyaira Hughes
//	Date						:3/13/21
//	Notes						:


////////////////////////////////////////////////////////////////////////
// Function Definitions
////////////////////////////////////////////////////////////////////////

//function definitions as decribed in the project manual 

//prints out an array of unsigned ints
void display_array(unsigned int* arr, int size){
	//Implement the function
	int i;
	printf("{");
	//iterates through array and prints out the elements in order
	for (i = 0; i < size; i++){
	//this if statement is to help format the array correctly when it prints out
		if(i == size-1){
			printf("%10d", arr[i]);
		}
		else	printf("%10d, ", arr[i]); 
	}
	printf("}");
}	

//Returns the number of 1s in bitwise representation of a number
unsigned int count_set_bits(unsigned int n){
	unsigned int count = 0;
	int i = 0;
	while (n){
	//increments count when '1' is detected
		count += bit_get(n, i);
	//shifts n by 1 bit
		n >>= 1;
	}
	return count;
}
//reverses an unsigned integer
unsigned int reverse_bitwise(unsigned int num){
	unsigned int rev = 0;
	unsigned int size = sizeof(num) * 8;
	int i;
	for(i = 0; i < size; i++){
	//shift the reverse int leftwards
		rev <<= 1;
	//when the current bit in num is 1 change the current bit in rev to 1
		if((num & 1)){
			rev ^= 1;
		}
	//shift int rightwards
		num >>= 1;
	}
	return rev;
}
//prints out an  unsigned int in binary using a char aray
void binary_string(char* str, unsigned int n){
	//count initialized to 32 to represent 32 bit and i initilized to zero for iteration
	int count = 32, i = 2;
	str[0] = '0';
	str[1] = 'b';
		while(count > 0){
	//while count is greater than zero the array at the count calls the bit_get function at the count position and and stores it in the array
			if(bit_get(n, count-1)){
				str[i] = '1';
			}
			else {
				str[i] = '0';
			}
	//count is decremented, i is incremented
		count--;
		i++;
		}
	//termination character
	str[34] = '\0';
	//print
		printf("%s", str);
	
}
//returns remainder of n/64
int bitwise_mod64(int n){
	//if neg returns 0
	if(bit_get(n,31) == 1)
		return 0;
	//returns the remainder of n when divided by 64
	else
		return n & 63;
}
//returns absolute value
int bitwise_abs(int n){
	int i = 1;
	//if the number is odd perform absolute value calculation
	if (bit_get(n, 31) == 1){
	//flip all bits in n;
		n = ~n;
	//while bits in n are not 0, flip
		while(n & i){
			n = n ^ i;
			i <<= 1;
		}
	//flip least significant bit
		n = n ^ i;
	}
	return n;
		
}

//returns bit at position n of a number
int bit_get(int num, int n){
	//shifts num n positions and determines if the bit is a 1 or 0 by using AND operator
	return (num >> n) & 1;
}
//determines if a number is odd or even
int odd_or_even(unsigned int n){
	//when a bit has a 1 in its 0th position it is odd, otherwise it is even
	return bit_get(n,0);
}
//swaps ints using XOR operator
void swap_ints(int* p1, int* p2){
	// if p1 and p2 are equal a swap does not need to occur
	if(p1 == p2)
		return;
	//bits of p1 are now the combined excusive or bits of both p1 and p2
	*p1 = *p1 ^ *p2;
	//doing exclusive or again of the new value of p1 and p2 now stores the previous value of p1 into p2
	*p2 = *p1 ^ *p2;
	//doing exclusive or of p1 and the new value of p2 now stores the old value of p2 into p1
	*p1 = *p1 ^ *p2;
}
