#include<stdio.h>

#include<math.h>

const double pi=3.1415927;

int main()

{

        freopen("in.txt", "r", stdin);
        freopen("out.txt", "w", stdout);

	int i=1,n;

	int year;

	double x,y,radius,area;

	scanf("%d",&n);

	while(n--)

	{

		scanf("%lf%lf",&x,&y);

		radius=x*x+y*y;

		area=pi*radius/2.0;

		year=(int)ceil(area/50.0);

		printf("Property %d:",i++);

		printf("This property will begin eroding in year %d./n",year);

	}

	printf("END OF OUTPUT./n");

	return 0;

} 