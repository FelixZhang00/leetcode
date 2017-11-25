
// #define LOCAL

#include<stdio.h>
#include<math.h>
typedef long long LL;  
  
LL X, Y, M, N, L;  
  
LL gcd(LL a, LL b) {  
    while(b) {  
        LL r = a % b;  
        a = b;  
        b = r;  
    }  
    return a;  
}  
  
void extend_gcd(LL a, LL b, LL &x, LL &y) {  
    if(b == 0) {  
        x = 1;  
        y = 0;  
        return ;  
    }  
    else {  
        extend_gcd(b, a % b, x, y);  
        LL tmp = x;  
        x = y;  
        y = tmp - a / b * y;  
    }  
}  
  

int main(int argc, const char * argv[]) {
  LL x, y, d;  
    while(~scanf("%d%d%d%d%d", &X, &Y, &M, &N, &L)) {  
        LL a = N - M;  
        LL b = L;  
        LL c = X - Y;  
        d = gcd(a, b);  
        if(c % d != 0) {  
            printf("Impossible\n");  
            continue;  
        }  
        a /= d;  
        b /= d;  
        c /= d;  
        extend_gcd(a, b, x, y);  
        LL t = c * x % b;  
        if(t < 0) t += b;  
        printf("%d\n", t);  
    }  
    return 0;  
}

