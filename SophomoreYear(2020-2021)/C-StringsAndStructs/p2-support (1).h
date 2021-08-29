///////////////////////////////////////////////////////////////////////////////////
//
// File			: p2-support.h
// Description		: Headers of general-purpose utility functions we use for
// 					the 257 project #2.
// Author					: Cyaira Hughes
// 	Date						: 4/9/21 
#define MAILBOX_SIZE 2000
#define ADRESS_SIZE 20
#define SUBJECT_SIZE 200
#define BODY_SIZE 2000
#define NAME_SIZE 20
//CHANGE TO VCU email below
#define user_email "hughesc2@mymail.vcu.edu"
//add other define Macros as needed
 
typedef struct Email
{	
	char* sender;
	char* receiver;
	char* subject;
	char* body;
	//add other struct members as needed
	//consider adding a nested struct here
 		struct send_date
		{
			int month;
			int day;
			int year;
			}date;
	int ID;
	    struct Email *next;
}Email;
 
struct Mailbox
{
        int size;
        //add other struct members as needed
	struct Email *emails;
};
 
/////////////////////////////////////////////////////////////////////////////////////
// This is a sample comment for the initialize function	
// You should include a similar comment for each function declared within the .h file
//
// Function     : initialize
// Description  : Initializes the database for CMSC257 project #2 by manually entering // the records using create_email function
// Inputs       : struct Mailbox* - pointer to the database    
// Outputs      : void
 
void initialize (struct Mailbox *ib);
 
//add other function declarations as needed
/////////////////////////////////////////////////////////////////////////////////////
// Function     : show_inbox
// Description  : Shows all emails in inbox
//
// Inputs       : n/a    
// Outputs      : Should print out the emails in the inbox as
//		  [ID- 2 digit 0 padded] - [Sender - left aligned] - [Date as mm/dd/yy] – [Subject truncated to 15 chars and left aligned]

void show_inbox();

/////////////////////////////////////////////////////////////////////////////////////
// Function     : show_email
// Description  : Shows email specified by ID
//
// Inputs       : n/a  
// Outputs      : Email should be printed as
//		  [Sender] - [Subject]
//                Email Received on: [Date as mm/dd/yyyy]
//                [Body]

void show_email_by_ID( int);

/////////////////////////////////////////////////////////////////////////////////////
// Function     : sort_by_sender
// Description  : Sorts the email's list lexicographically by the senders email address
//
// Inputs       : n/a  
// Outputs      : Inbox in lexographic order by sender

void sort_by_sender();

/////////////////////////////////////////////////////////////////////////////////////
// Function     : sort_by_ID
// Description  : Sorts the email's list by the date received with newest being at 
//		  the beginning of the list and oldest being at the end of the list.
//
// Inputs       : n/a 
// Outputs      : Inbox in order by date recieved

void sort_by_ID();

/////////////////////////////////////////////////////////////////////////////////////
// Function     : sort_by_keyword
// Description  : Searches the emails in your inbox given a string and displays all 
//		  the emails including that keyword within the sender, subject or body fields.
//
// Inputs       : String  
// Outputs      : Inbox of senders containing keyword

void search_by_keyword(char*);

/////////////////////////////////////////////////////////////////////////////////////
// Function     : delete
// Description  : Given an email ID this should delete that email. You need to maintain 
//		  the inbox after deleting an email. (update the inbox size and re-arrange 
//                the emails array so that deleted email will not be printed again)
//
// Inputs       : ID, int  
// Outputs      : void

void delete(struct Mailbox *ib, int);

/////////////////////////////////////////////////////////////////////////////////////
// Function     : quit
// Description  : Exits the program
//
// Inputs       : ID 
// Outputs      : void		  

void quit(struct Mailbox *ib);

/////////////////////////////////////////////////////////////////////////////////////
// Function	:  create_email
// Description	: Creates an email given a sender, receiver, subject, body, date and mailbox
//
// Inputs	: char*,char*,char*,char*,int,int,int, ib
// Outputs	: void

void create_email(char*, char*, char*, char*, int, int, int, struct Mailbox*);
/////////////////////////////////////////////////////////////////////////////////////
// Function	: display_inbox_menu
// Description	: Displays inbox
//
// Input	: mailbox
// Outputs	:inbox menu
void display_inbox_menu(struct Mailbox* ib);

/////////////////////////////////////////////////////////////////////////////////////
// Function	: swap
// Description	: Swaps two email nodes
//
// Input	: Email a and Email b
// Outputs	: void
void swap(Email* a, Email* b);
//
//
//
//
