#include <stdio.h>
#include <string.h>

int main() {

	char day[10];
	char food[20];
	printf("Enter a food");
	scanf("%s",food);

	printf("Enter a day: ");
	scanf("%s", day);

	if(strcmp(day,"Sunday") == 0 || (strcmp(day,"Monday"))==0 || (strcmp(day, "Tuesday")==0) && (food[0]=='m') || (food[0]=='k')) 
	{
		printf("Sorry in Sunday, Monday, and Tuesday Cole can't eat %s",food);
	}

return 0;
}