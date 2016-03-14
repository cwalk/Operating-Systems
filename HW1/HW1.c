/*
Clayton Walker
COP 4600 Fall 2013
HW #1
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <signal.h>
#define MAX_BUFFER 1024                        // max line buffer
#define MAX_ARGS 64                            // max # args
#define SEPARATORS " \t\n"                     // token sparators, with newline, tab, and space

int main (int argc, char ** argv)
{
    char buf[MAX_BUFFER];                      // line buffer
    char * args[MAX_ARGS];                     // pointers to arg strings
    char ** arg;                               // working pointer thru args
    char * prompt = "# " ;                    // shell prompt is #

// read input until "quit" command or end of input
    while (!feof(stdin)) {

// get command line from input
        fputs (prompt, stdout);                // write to prompt
        if (fgets (buf, MAX_BUFFER, stdin )) { // reads line

// tokenize the input into args array
            arg = args;
            *arg++ = strtok(buf,SEPARATORS);   // tokenize input
            while ((*arg++ = strtok(NULL,SEPARATORS)));
                                               // last entry will be NULL

            if (args[0]) {                     // if there's 1 command

				pid_t pid;

                /**Interprets the first word as the full path to the program to execute, and the others as parameters. **/
				if (strcmp(args[0], "run") == 0) {
					//we fork the process
                    pid = fork();
					//Error checking
                    if (pid < 0) {
							fprintf(stdout, "There was an error, Fork Failure!\n");
							exit(1);
					}
					if (pid == 0) {
							fprintf(stdout, "This is the child\n");
							execlp(args[1], args[1], NULL);
							exit(0);
					}
					else {
						int childExitStatus;
						pid_t vs = waitpid(pid, &childExitStatus, 0);
					}
				}

				/**immediately prints the PID of the program it started, and returns the prompt.**/
				if (strcmp(args[0], "background") == 0) {
					pid = fork();
					if (pid < 0) {
						//fprintf(stdout, "1");
                        fprintf(stdout, "%d", pid);
							exit(1);
					}
					if (pid == 0) {
							fprintf(stdout, "0");
							execlp(args[1], args[1], NULL);
							exit(0);
					}
					else {
						int childExitStatus;
						pid_t vs = waitpid(pid, &childExitStatus, 0);
					}
				}

				/**Immediately terminate the program with the specific PID**/
				if (strcmp(args[0], "murder") == 0) {
					int  killSignal = killpg((int) args[1], SIGKILL);
				}

                /**Terminates the program**/
                if (strcmp(args[0],"quit") == 0)   // "quit" command
                    break;                     // break out of 'while' loop

                //ends program
                arg = args;
                while (*arg) fprintf(stdout,"%s ",*arg++);
                fputs ("\n", stdout);
            }
        }
    }
    return 0;
}
