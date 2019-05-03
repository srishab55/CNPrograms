#include<sys/ipc.h>
#include<sys/msg.h>
#include<stdio.h>

struct message_form{

long message_type;
char msg[200];
}message;

int main ()
{
	key_t key;
	key=ftok("progfile",65);
	int msg_id=msgget(key,0666|IPC_CREAT);
	msgrcv(msg_id,&message,sizeof(message),1,0);

	printf("Data read is %s",message.msg);
}
