#include <stdio.h>
#include <stdlib.h>
int main(){
	int n;
	scanf("%d",&n);
	char* number[n];

	//给指针分配空间
	for (int i = 0; i < n; ++i)
	{
		number[i]=(char*)malloc(sizeof(char)); 
	}

	//输入
	for (int i = 0; i < n; ++i)
	{
	scanf("%s",number[i]); //scanf函数会自动忽略空格
	}

    printf("\n");
	//输出
	for (int i = 0; i < n; ++i)
	{
		printf("%s\n",number[i]);
	}

	return 0;
}