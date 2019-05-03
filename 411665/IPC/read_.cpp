#include<sys/ipc.h>
#include<sys/shm.h>
#include<stdio.h>

int main ()
{
	key_t key;
	key=ftok("shmfile",65);
	int shmid= shmget(key,1024,0666|IPC_CREAT);
	char *msg=(char*) shmat(shmid,(void*)0,0);
	printf("msg is %s",msg);
	shmdt(msg);
}
