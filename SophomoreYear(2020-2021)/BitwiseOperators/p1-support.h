#ifndef CMSC257_P1SUPPORT_INCLUDED
#define CMSC257_P1SUPPORT_INCLUDED
////////////////////////////////////////////////////////////////////////
//
//  File          	: p1support.h
//  Description    	: Headers of general-purpose utility functions 
//					we use for the 257 project #1.
//  Author					:Cyaira Hughes
//	Date						:3/9/21
//	Notes						:
////////////////////////////////////////////////////////////////////////
//	Add comments for each function below in the following format
////////////////////////////////////////////////////////////////////////
//
// 	Function     : display_array
// 	Description  : Prints out the array of integer values
// 
// 	Inputs       : an array of 10 integers
// 	Outputs      : void
////////////////////////////////////////////////////////////////////////
//
// 	Function     : count_set_bits
// 	Description  : Returns the number of 1s in bitwise representation of a number
// 
// 	Inputs       : unsigned int
// 	Outputs      : unsigned int

//////////////////////////////////////////////////////////////////////
//
// 	Function     : reverse_bitwise
// 	Description  : Returns number whose bits are reversed
// 
// 	Inputs       : unsigned int
// 	Outputs      : unsigned int
////////////////////////////////////////////////////////////////////////
//
// 	Function     : binary_string
// 	Description  : Fills the text string with a binary representation of the number suitable for printing
// 
// 	Inputs       : char*, unsigned int
// 	Outputs      : void
///////////////////////////////////////////////////////////////////////
//
// 	Function     : bitwise_mod64
// 	Description  : returns mod64 using bitwise operations
// 
// 	Inputs       : int
// 	Outputs      : int
////////////////////////////////////////////////////////////////////////
//
// 	Function     : bitwise_abs
// 	Description  : Returnsabsolute value of integer
// 
// 	Inputs       : int
// 	Outputs      : int

///////////////////////////////////////////////////////////////////////
//
// 	Function     : bit_get
// 	Description  : Extracts specified bit from a given number
// 
// 	Inputs       : int, int
// 	Outputs      : int
////////////////////////////////////////////////////////////////////////
//
// 	Function     : odd_or_even
// 	Description  : returns if unsigned int is odd or even
// 
// 	Inputs       : unsigned int
// 	Outputs      : int
///////////////////////////////////////////////////////////////////////
//
// 	Function     : swap_ints
// 	Description  : Swaps numbers
// 
// 	Inputs       : int*, int*
// 	Outputs      : void
//////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////
// Functional Prototypes
////////////////////////////////////////////////////////////////////////

// This function prints out the array of integer values
void display_array(unsigned int*, int);

// Add other function prototypes
//Returns the nunber of 1s in bitwise representation of a number
unsigned int count_set_bits(unsigned int);

//Returns the number whose bits are reversed
unsigned int reverse_bitwise(unsigned int);

//Fills the text string with a binary representation of the number suitible for printing
void binary_string(char*, unsigned int);

//Returns mod 64 using bitwise operations
int bitwise_mod64(int);

//Returns the absolute value of input integer
int bitwise_abs(int);

//Extracts the specified bit from a given number
int bit_get(int, int);
//Determines if unsigned integer is odd "1" or even "0"
int odd_or_even(unsigned int);

//Swaps integers
void swap_int(int*, int*);

#endif // CMSC257_P1SUPPORT_INCLUDED
