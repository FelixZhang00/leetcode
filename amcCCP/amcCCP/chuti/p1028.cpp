/*********************************
*   日期：2013-3-3
*   作者：SJF0115
*   题号: 九度OJ 题目1007：奥运排序问题
*   来源：http://ac.jobdu.com/problem.php?pid=1007
*   结果：AC
*   来源：2011年浙江大学计算机及软件工程研究生机试真题
*   总结：
**********************************/
#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

//结构体
typedef struct Country{
    int GoldNum;//金牌数
    int MedalNum;//奖牌数
    int PeopleNum;//人口数
    double GoldRatio;//金牌比例
    double MedalRatio;//奖牌比例
    int SKind;//最佳排名类型
    int BestRank;//最佳排名
    int Rank;//当前排名
}Country;

Country country[1000];

int main () {
    int N,M,i,j,ID;
    Country countrySort[1001];
    while(scanf("%d %d",&N,&M) != EOF){
        //给定国家或地区的奥运金牌数，奖牌数，人口数（百万）。
        for(i = 0;i < N;i++){
            scanf("%d %d %d",&country[i].GoldNum,&country[i].MedalNum,&country[i].PeopleNum);
            country[i].GoldRatio = country[i].GoldNum * 1.0 / country[i].PeopleNum;
            country[i].MedalRatio = country[i].MedalNum * 1.0 / country[i].PeopleNum;
        }
        //给出要排序的M个国家号。
        for(i = 0;i < M;i++){
            scanf("%d",&ID);
            countrySort[i] = country[ID];
        }
        for(i = 0;i < M;i++){
            //金牌数排序
            countrySort[i].Rank = 1;
            for(j = 0;j < M;j++){
                if(countrySort[i].GoldNum < countrySort[j].GoldNum){
                    countrySort[i].Rank++;
                }
            }
            countrySort[i].BestRank = countrySort[i].Rank;
            //printf("J:%d\n",countrySort[i].BestRank);
            countrySort[i].SKind = 1;
            //奖牌数排序
            countrySort[i].Rank = 1;
            for(j = 0;j < N;j++){
                if(countrySort[i].MedalNum < countrySort[j].MedalNum){
                    countrySort[i].Rank++;
                }
            }
            if(countrySort[i].Rank < countrySort[i].BestRank){
                countrySort[i].BestRank = countrySort[i].Rank;
                countrySort[i].SKind = 2;
            }
            //printf("J2:%d\n",countrySort[i].Rank);
            //金牌人口比例排序
            countrySort[i].Rank = 1;
            for(j = 0;j < N;j++){
                if(countrySort[i].GoldRatio < countrySort[j].GoldRatio){
                    countrySort[i].Rank++;
                }
            }
            if(countrySort[i].Rank < countrySort[i].BestRank){
                countrySort[i].BestRank = countrySort[i].Rank;
                countrySort[i].SKind = 3;
            }
            //printf("J3:%d\n",countrySort[i].Rank);
            //奖牌人口比例排序
            countrySort[i].Rank = 1;
            for(j = 0;j < N;j++){
                if(countrySort[i].MedalRatio < countrySort[j].MedalRatio){
                    countrySort[i].Rank++;
                }
            }
            if(countrySort[i].Rank < countrySort[i].BestRank){
                countrySort[i].BestRank = countrySort[i].Rank;
                countrySort[i].SKind = 4;
            }
            //printf("J4:%d\n",countrySort[i].Rank);
            //输出
            printf("%d:%d\n",countrySort[i].BestRank,countrySort[i].SKind);
        }
        //每组数据后加一个空行。
        printf("\n");
    }//while
    return 0;
}
