///////////////////////////////////////////////////////////////////////////////////
//
// File			: shellex.c
// Description		: Creates a simple Unix shell
//				-The shell is a program that interacts with the 
//				user through a terminal or takes the input from a 
//				file and executes a sequence of commands that are passed 
//                      	to the Operating System.
// 					
// Author		: Cyaira Hughes
// Date			: 4/26/21 
////////////////////////////////////////////////////////////////////////////////////

/* $begin shellmain */
#include "csapp.h"
#define MAXARGS   128

/* Function prototypes */
void eval(char *cmdline);
int parseline(char *buf, char **argv);
int builtin_command(char **argv);
void ctrlC_handler(int sig);
void Exit(int ret);
void GetPid();
void GetPpid();
void pcwd(char **argv);
void cwwd(char *str);
void help();
/* Global shell prompt variable */
char *defaultPrompt = "my257sh";

/* Signal handler for ^C */
void ctrlC_handler(int sig){
	printf("\n%s>", defaultPrompt);
	//moves back to console
	fflush(stdout);
	return;
}
/* Exit function using raise() */
void Exit(int ret){
	ret = raise(SIGTERM);
	if (ret != 0){
		printf("Error: unable to raise SIGINT signal. \n");
		exit(0);
	}
	printf("Terminated");
	//fflush(stdout);
}
/* Wrapper function that prints out process id number */
void GetPid(){printf("%d\n", getpid());}

/* Wrapper function that prints out parent process id number */
void GetPpid(){printf("%d\n", getppid());}

/* Wrapper function that prints out current working directory */
void pcwd(char **argv){printf("%s\n",getcwd(argv, MAXARGS));}

/* Function that changes current directory based on path given from console */
void ccwd(char* str){chdir(str);}

/* Help function that explains purpose of program */
void help(){
	printf("Simple Unix Shell\n");
	printf("How to change shell prompt: ./shellex -p <prompt>\n\n");
	printf("List of build in commands:\n");
	printf("pid -\t prints process id of the shell\n"
			"ppid -\t prints parent process id of the shell\n"
			"cd -\t prints current working directory\n"
			"cd <path> -\t changes current working directory\n\n"
			"Use 'man' command to get help if looking for non-built-in commands\n");


}
int main(int argc, char*argv[])
{
	char cmdline[MAXLINE]; /* Command line */

	//when user enters <executable> -p <prompt> defaultPrompt is changed to user defined prompt
	if (argc == 3){
		if(strcmp(argv[1], "-p") == 0)
		defaultPrompt = argv[2];
	}
	//when ^C signal is detected, program calls signal handler and does nothing
	if (signal(SIGINT, ctrlC_handler) == SIG_ERR)
		unix_error("signal error");


	while (1) {
		/* Read */
		printf("%s>", defaultPrompt);
		fflush(stdout);
		Fgets(cmdline, MAXLINE, stdin);
		if (feof(stdin))
			exit(0);
		/* Evaluate */
		eval(cmdline);
	}
}
/* $end shellmain */

/* $begin eval */
/* eval - Evaluate a command line */
void eval(char *cmdline)
{
	char *argv[MAXARGS]; /* Argument list execve() */
	char buf[MAXLINE];   /* Holds modified command line */
	int bg;              /* Should the job run in bg or fg? */
	pid_t pid;           /* Process id */
	strcpy(buf, cmdline);
	bg = parseline(buf, argv);
	if (argv[0] == NULL)
		return;   /* Ignore empty lines */

	//if input command is not built-in to program
	if (!builtin_command(argv)) {
		if ((pid = Fork()) == 0) {   /* Child runs user job */
			//Error statement is printed when command cannot be found, exit status 1
			//otherwise command is implentented
			if(execvp(argv[0], argv) < 0){
				printf("Execution failed (in fork)\n: No such file or directory\n");
				exit(1);
			}
		}
		/* Parent waits for foreground job to terminate */
		if (!bg) {
			//grabs exit status of child
			int status;
			//reap child
			if (waitpid(pid, &status, 0) < 0)
				unix_error("waitfg: waitpid error");
			if( WIFEXITED(status))
				//exit status is given
				printf("Child exit status: %d\n", WEXITSTATUS(status));

		}
		else
			printf("%d %s", pid, cmdline);

	}
	return;
}

/* If first arg is a builtin command, run it and return true */
int builtin_command(char **argv)
{
	int ret;
	if (!strcmp(argv[0], "exit")){ /* exit command */
		Exit(ret);
	}
if (!strcmp(argv[0], "pid")){    /* pid command */
	GetPid();
	return 1;
}
if (!strcmp(argv[0], "ppid")){  /* ppid command */
	GetPpid();
	return 1;
}
if (!strcmp(argv[0], "help")){  /* help command */
	help();
	return 1;
}
if (!strcmp(argv[0], "cd")){    /* cd commands */
	if (argv[1] == NULL)
		pcwd(argv);
	else
		ccwd(argv[1]);
	return 1;
}
return 0;                     /* Not a builtin command */
}
/* $end eval */
/* $begin parseline */
/* parseline - Parse the command line and build the argv array */
int parseline(char *buf, char **argv)
{
	char *delim;         /* Points to first space delimiter */
	int argc;            /* Number of args */
	int bg;              /* Background job? */

	buf[strlen(buf)-1] = ' ';  /* Replace trailing '\n' with space */
	while (*buf && (*buf == ' ')) /* Ignore leading spaces */
		buf++;

	/* Build the argv list */
	argc = 0;
	while ((delim = strchr(buf, ' '))) {
		argv[argc++] = buf;
		*delim = '\0';
		buf = delim + 1;
		while (*buf && (*buf == ' ')) /* Ignore spaces */
			buf++;
	}
	argv[argc] = NULL;

	if (argc == 0)  /* Ignore blank line */
		return 1;

	/* Should the job run in the background? */
	if ((bg = (*argv[argc-1] == '&')) != 0)
		argv[--argc] = NULL;

	return bg;
}
/* $end parseline */
