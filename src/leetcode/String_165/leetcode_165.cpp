/**
通过测试 0ms！！
**/
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int compareVersion(string version1, string version2) {
        string v1,v2;
        v1=version1;
        v2=version2;

        int i1,i2;
        while(v1.length()!=0&&v2.length()!=0){
//            cout<<"v1="<<v1<<"v2="<<v2<<endl;
            i1=divideHead(v1);
            i2=divideHead(v2);
            if(i1>i2){
                return 1;
            }else if(i1<i2){
                return -1;
            }
        }

        if(v1.length()!=0){
            if(isZeros(v1)) return 0;
            return 1;
        }
        if(v2.length()!=0){
            if(isZeros(v2)) return 0;
            return -1;
        }

        return 0;

    }

    bool isZeros(string s){
        for(int i=0;i<s.length();i++){
            char c=s[i];
            if(c!='0'&&c!='.')return false;
        }
        return true;
    }

    int divideHead(string& str){
        int i=0;
        for(;i<str.length();i++){
            if(str[i]=='.') break;
        }
        string head=str.substr(0,i);
        if(i==str.length()){
            str="";
        }else{
            str=str.substr(i+1,str.length()-i-1);
        }
        return atoi(head.c_str());
    }


};

int main(){
//    cout<<"hello"<<endl;
    Solution solution;
    string s1="01";
    string s2="01.1";
    cout<<"get head int of "<<s1<<":  "<< solution.divideHead(s1)<<endl;
    cout<< "get head int of "<<s2<<":  "<<solution.divideHead(s2)<<endl;

//    cout<< solution.compareVersion("01","1")<<endl;

    //测试
//    string v1="1";
//    cout<<solution.divideHead(v1)<<endl;

//    cout<<solution.isZeros("0.0.0")<<endl;

    cout<<solution.compareVersion("10.6.5","10.6.1")<<endl;
    return 0;
}
