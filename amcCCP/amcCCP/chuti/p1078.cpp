/*
定理:如果G是连通图,则G是欧拉图当且仅当G的所有顶点都是偶顶点
证明(粗略)如下:
必要性:如果是欧拉图,有进有出,很容易就能判断G连通且所有顶点都是偶定点.
充分性:就是构造欧拉回路,去掉后再看剩下的部分是否是个欧拉图..
*/
#include <cstdio>
#include <string.h>
#include <ctype.h>

int tree[1001];
int deg[1001];
//从缓冲区读入int,注意如果后面需要读入char的时候.
inline bool getint(int &x){
    x = 0;
    int mute = 1;
    char c;
    while(!isdigit(c = getchar()) && c != '-')
        if(c == -1)
            return false;
    c == '-' ? mute = -1 : x = c - '0';
    while(isdigit(c = getchar()))
        x = (x << 1) + (x << 3) + c - '0';
    x *= mute;
    return true;
}

//并查集findroot.
inline int find(int x){
    if(tree[x] == -1)
        return x;
    else{
        int tmp = find(tree[x]);
        tree[x] = tmp;
        return tmp;
    }
}

int main(){
    int n, m, a, b, i, sum;
    bool yes;
    while(getint(n) && n){
        getint(m);
        yes = true;
        memset(tree, -1, sizeof(tree));
        memset(deg, 0, sizeof(deg));
        for(i = 1; i <= m; i++){
            getint(a);
            getint(b);
            deg[a]++;
            deg[b]++;
            a = find(a);
            b = find(b);
            if(a != b)
                tree[a] = b;
        }
        sum = 0;
        for(i = 1; i <= n; i++){
            if(deg[i] % 2 != 0)
                yes = false;
            if(tree[i] == -1)
                sum++;
        }
        if(sum >= 2)
            yes = false;
        puts(yes ? "1" : "0");
    }
    return 0;
}