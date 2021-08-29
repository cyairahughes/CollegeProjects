//Add program description, author name, last edit date as in the project1
////////////////////////////////////////////////////////////////////////
//
//  File           : cmsc257-s21-p2.c
//  Description    : This is the main source code for for the second 
//					 project of CMSC257.  
//					 See the related assignment page for details.
//
//   Author        :Cyaira Hughes
//   Last Modified :4/9/21
//
//Do not modify anything below this line

#include <stdio.h>
#include <stdlib.h>
#include "p2-support.h"

int main(){
        struct Mailbox* ib;
        ib = (struct Mailbox*) malloc(sizeof(struct Mailbox));
        initialize(ib);
        display_inbox_menu(ib);
        free (ib);
        return 0;
}

