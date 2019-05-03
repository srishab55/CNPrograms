#include<sys/ipc.h>
#include<sys/msg.h>
#include<stdio.h>
struct message_form{

long msg_type;
char msg[200];
}message;

int main ()
{
	key_t key;
	key=ftok("progfile",65);

	int msg_id=msgget(key,0666|IPC_CREAT);

	printf("Write data \n");
	gets(message.msg);
	message.msg_type=1;
	msgsnd(msg_id,&message,sizeof(message),1);

	printf("data send is %s",message.msg);
}
