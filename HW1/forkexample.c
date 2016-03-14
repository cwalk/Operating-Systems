#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(char *argc[], int argv) {
    printf("Here we are before fork\n");
    pid_t pid;
    pid = fork();
    if (pid < 0) {
            printf("There was an error!\n");
            exit(1);
    }
    if (pid == 0) {
            printf("This is the child\n");
            execlp("/usr/bin/xterm", "ls", NULL);
            exit(0);
    }
    printf("This is the parent and the child's pid is %d\n", pid);
    pid = fork();
    if (pid < 0) {
            printf("There was an error!\n");
            exit(1);
    }
    if (pid == 0) {
            printf("This is the child\n");
            execlp("/usr/bin/xfontsel", "ls", NULL);
            exit(0);
    }
    printf("This is the parent and the child's pid is %d\n", pid);
    pid_t whofinished = wait(NULL);
    printf("Child's pid which finished is %d\n", whofinished);
}
