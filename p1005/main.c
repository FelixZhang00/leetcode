
// #define LOCAL

#include<stdio.h>
#include<math.h>
int main(int argc, const char * argv[]) {
   // #ifdef LOCAL
   //      freopen("in.txt", "r", stdin);
   //      freopen("out.txt", "w", stdout);
   //  #endif

	const float PI=3.1415926;
	const float SHRINK=50.0;
	int n=0,year=0,count=0;
	float x=0,y=0, area=0;
	scanf("%d",&n);
	while(n--){
		scanf("%f%f",&x,&y);
		area=PI*(x*x+y*y)/2;
		year=(int)ceil(area/SHRINK);
		count++;
		printf("Property %d: This property will begin eroding in year %d.\n",count,year);
	}
	printf("END OF OUTPUT.");
	return 0;
}