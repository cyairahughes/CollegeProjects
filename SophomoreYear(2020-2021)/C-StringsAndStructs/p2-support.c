#include "p2-support.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
//Add program description, author name, last edit date as in project1
////////////////////////////////////////////////////////////////////////
//
//  File          	: p2-support.c
//  Description    	: Utility functions for project 2
//  Author					:Cyaira Hughes
//	Date						:4/04/21
//	Notes
//Add necessary include statements
//global email pointer
Email *head;


void
initialize (struct Mailbox *ib)
{
  //allocate memory for 2000 emails
  ib->emails = malloc (sizeof (struct Email) * MAILBOX_SIZE);
  ib->size = 0;
 
 
  create_email ("asonmez@mail.com", user_email, "Welcome to your inbox.",
                "Welcome to your inbox, just wanted to say hi. Here's hoping you get all your code done.",
                 11,20,2020, ib);
  create_email ("mmartinez@mail.com", user_email, "Padding out your inbox.",
                "Yet another email just to pad out your inbox, have fun!",
                 11,30,2020, ib);
  create_email ("dboyle@mail.com", user_email, "3rd email!",
                "Alright, time for another email for your inbox. Not going too lie, it's a bit of a pain coming up with stuff for these strings. Anyways, have fun with your code!",
                 12,2,2020, ib);
  create_email ("cbluer@mail.com", user_email, "4th email!",
                "Content of fourth email. More coding, more fun!",
                 12,8,2020, ib);
  create_email ("cboyle@mail.com", user_email, "5th email!",
                "Content of fifth email. Coding is fun-tastic!",
                 12,18,2020, ib);
  create_email ("sblack@mail.com", user_email, "6th email!",
                "Content of fifth email. Coding is fun-tastic!",
                 1,1,2021, ib);
  create_email ("sblack@mail.com", user_email, "7th email!",
                "Body of sixth email. Coding is fun-tastic!",
                 1,5,2021, ib);
  create_email ("sblack@mail.com", user_email, "8th email!",
                "Body of eighth email. Coding is fun-tastic!",
                 2,15,2021, ib);
  create_email ("sblack@mail.com", user_email, "9th email!",
                "Body of ninth email. Coding is fun-tastic!",
                 2,25,2021, ib);
  create_email ("dboyle@mail.com", user_email, "Last email!",
                "Body of tentth email. Coding is fun-tastic!",
                 3,15,2021, ib);
 
}
//creates email using linked list append function
void create_email(char* send, char* receive, char* sub, char* bod, int m, int d, int y, struct Mailbox* ib)
{
//allocates email
    Email* e = (Email*) malloc(sizeof(Email));
    Email *last = head;
//put in data
    e->sender = send;
	e->receiver = receive;
	e->subject = sub;
	e->body = bod;
	e->date.month = m;
	e->date.day = d;
	e->date.year = y;
	
	ib->size += 1;
	e->ID = (ib->size)-1;
//make this node the last node
	e->next = NULL;
//if the linked list is empty, make the new email as the head email
	if(head == NULL){
	    head = e;
	    return;
	}
//else traverse until the last node	
	while(last->next != NULL){
	    last= last->next;
	   
	}
//change the next of last node
	last->next = e;
	
	return;
	
}
//displays inbox menu
void display_inbox_menu (struct Mailbox *ib)
{
    int i, num;
    char keyword[BODY_SIZE];
   
//prints out inbox menu   
    while(1){
	printf("\n***************   HUGHESC2 INBOX   ***************\n"
		   "***************   Total Inbox: %04d  ***************\n\n", ib->size);
	printf("1. Show Inbox\n");
	printf("2. Show Email by ID\n");
	printf("3. Sort Inbox by Sender\n");
	printf("4. Sort Inbox by ID\n");
	printf("5. Search Inbox by Keyword\n");
	printf("6. Delete\n");
	printf("7. Exit Inbox\n\n");
	scanf("%d", &i);
	switch(i)
	{
//if '1' call show_inbox function
	    case 1: show_inbox();
	            break;
//if '2' display printf and call show_email_by_id according to input	    
	    case 2: printf("\nEnter the ID of the email you want to read:\n");
	            scanf("%d", &num);
	            show_email_by_ID(num);
	            break;
//if '3' call sort_by_sender function
	    case 3: sort_by_sender();
	      	    break;
//if '4' call sort_by_id function
	    case 4: sort_by_ID();
	            break;
//if '5' display printf and call search_by_keyword according to input
	    case 5: printf("\nEnter the keyword you wish to search for:\n");
	            scanf("%s", keyword);
	            search_by_keyword(keyword);
	            break;
//if '6' display printf and call delete according to input
	    case 6: printf("\nEnter the ID of the email you wish to delete:\n");
	            scanf("%d", &num);
	            delete(ib,num);
	            break;
//if '7' call quit function
	    case 7: quit(ib);
	            return 0;
//else display printf
	    default: printf("Invalid option\n");
	             break;
	}
    }
	

}
//shows inbox
void show_inbox(){
//start at head email
    Email* e;
    e = head;
    printf("\nID   SENDER---------------   MM/DD/YYYY   SUBJECT--------\n"
           "--   ---------------------   --/--/----   ---------------\n");
//while node is not null print out inbox
    while(e != NULL){
//concats string to 15 chars
        char str2[15];
        strncpy (str2,e->subject,15); 
        str2[15]='\0';
        printf("%02d - %-s\t   - %02d/%02d/%d - %0s\n", e->ID, e->sender, e->date.month, e->date.day, e->date.year, str2);
            e = e->next;
    }


}
//shows email according to id
void show_email_by_ID(int id){
//start at head email
    Email* e = head;
//while email id is not equal to id traverse
    while(e->ID != id){
         e = e->next;
    }
//print email
    printf("\n%s - %s\nEmail Recieved on: %02d/%02d/%d\n\n%s\n\n",e->sender, e->subject,e->date.month, e->date.day, e->date.year, e->body);
}
//sorts emails by sender using bubble sort method
void sort_by_sender(){
    int swapped;
    Email *e;
    Email *lptr = NULL;
  
//checks or empty list
    if (head == NULL)
        return;
  
    do
    {
//make swapped = 0
        swapped = 0;
//start at head email
        e = head;
        while (e->next != lptr)
        {
//if sender and next sender are not in alphabetical order, swap
            if (strcmp(e->sender, e->next->sender) > 0)
            { 
                swap(e, e->next);
                swapped = 1;
            }
            
            e = e->next;
        }
        lptr = e;
    }
    while (swapped);
    
}
//swaps data in emails
void swap(Email *a, Email *b)
{
 char* sender, *receiver, *subject, *body;
 int month, day, year, id;
 
    sender = a->sender;
	receiver = a->receiver;
	subject = a->subject;
	body = a->body;
	month = a->date.month;
	day = a->date.day;
	year = a->date.year;
	id = a->ID;
    a->sender = b->sender;
    a->receiver = b->receiver;
	a->subject = b->subject;
	a->body = b->body;
	a->date.month = b->date.month;
	a->date.day = b->date.day;
	a->date.year = b->date.year;
	a->ID = b->ID;
    b->sender = sender;
    b->receiver = receiver;
	b->subject = subject;
	b->body = body;
	b->date.month = month;
	b->date.day = day;
	b->date.year = year;
	b->ID = id;
}
//same method as previous sort function, but sorts by date
void sort_by_ID(){
    int swapped;
    Email *e;
    Email *lptr = NULL;
  
    
    if (head == NULL)
        return;
  
    do
    {
        swapped = 0;
        e = head;
  
        while (e->next != lptr)
        {
            if (e->date.year > e->next->date.year){
            swap(e, e->next);
            swapped = 1;
            }
            if(e->date.year == e->next->date.year && e->date.month > e->next->date.month){
            swap(e, e->next);
            swapped = 1;
            }
            if(e->date.year == e->next->date.year && e->date.month == e->next->date.month && e->date.day > e->next->date.day){
            swap(e, e->next);
            swapped = 1;
            }
            
            e = e->next;
        }
        lptr = e;
    }
    while (swapped);
        
}
//searches all emails for keyword
void search_by_keyword(char* keyword){
//start at head email
    Email* e = head;
    
    printf("\n\nID   SENDER---------------   MM/DD/YYYY   SUBJECT--------\n"
           "--   ---------------------   --/--/----   ---------------\n");
//while email is not null, if email contains keyword, print email
    while(e != NULL){
        if(strstr(e->sender, keyword) != NULL || strstr(e->subject, keyword) != NULL || strstr(e->body, keyword) != NULL){
             printf("%02d - %-s\t   - %02d/%02d/%d - %0s\n", e->ID, e->sender, e->date.month, e->date.day, e->date.year, e->subject);
        } 
        e = e->next;
    }
}
//deletes email   
void delete(struct Mailbox *ib, int id){
    Email *curr, *prev;
//prev email equals null, start at head email
	prev = NULL;
	curr = head;
//if curr is not null and the email matches the id specifed, free memory of that email
	if(curr != NULL && curr->ID == id){
		head = curr->next;
		free(curr);
		return 1;
	}
	while(curr != NULL){
		if(curr->ID == id && curr->next != NULL){
			prev->next = curr->next;
			free(curr);
			ib->size--;
			printf("Email with ID = %d is deleted\n\n", id);
			return 1;
		}
	prev = curr;
	curr = curr->next;
	}
	return 0;
}
//exits program
void quit(struct Mailbox* ib){
//start at head node
    Email *curr = head, *next = NULL;
//free all emails
    while(curr != next){
		next = curr->next;
		free(curr);
		curr = next;
	}
	head = NULL;
printf("Exiting e-mail client - Good Bye!\n\n");	
}
