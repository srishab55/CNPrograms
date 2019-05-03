#include<string.h>
#include<fcntl.h>
#include<stdio.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<unistd.h>

int main ()
{
	char *filepath="/myfifo";
	mkfifo(filepath,0666);
char arr1[60],arr2[60];
	int fd;
	while(1)
	{
		fd=open(filepath,O_WRONLY);
		fgets(arr2,80,stdin);
		write(fd,arr2,strlen(arr2)+1);
		close(fd);

		fd=open(filepath,O_RDONLY);
		read(fd,arr1,sizeof(arr1));
		printf("user2 %s",arr1);
		close(fd);
	}
}
