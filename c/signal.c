#include <signal.h>
#include <stdio.h>
#include <unistd.h>
 
void my_handler(int signum) {
  const char msg[] = "Signal handler got signal\n";
  write(STDOUT_FILENO, msg, sizeof msg);
}
 
int main(int argc, char *argv[]) {
  printf("PID: %d\n", getpid());
 
  // Set up signal handler
  struct sigaction action = {};
  action.sa_handler = &my_handler;
  sigaction(SIGINT, &action, NULL);
 
  while (1) {
    pause();
  }
  return 0;
}
