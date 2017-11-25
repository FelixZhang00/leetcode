package p1001.refer;

import java.util.*;
public class refer2 {

   public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
      while(sc.hasNext()){
        String s=sc.next();
        int n=sc.nextInt();
       String result=exponentiation(s,n);
        if(result.startsWith("0."))   
                result = result.substring(1);   
               
           
        while( result.endsWith("0"))   
                result= result.substring(0,result.length()-1);   

       if(result.endsWith("."))   
                result = result.substring(0,result.length()-1);   
       System.out.println(result);

      }
   }
public static String exponentiation(String data,int n){

  // 找小数点
  int index = data.indexOf(".");
  // 去掉小数点
  String temp = data.replace(".","");

  // 用数组表示输入的数据
  byte[] inputData=new byte[temp.length()];
  // 表示计算结果

  byte[] result = new byte[160];
  // 表示进位
  byte pre=0;
  // 初始化
  for(int i=0;i<inputData.length;i++){
     result[i] = Byte.parseByte(temp.substring(temp.length()-i-1,temp.length()-i));
    inputData[i] = result[i];
  }

              

   // 计算n-1遍
   for(int i=0;i<n-1;i++){
     // 表示上一次的计算结果
     byte[] tempResult = Arrays.copyOf(result,result.length);
     // 对result初始化
     Arrays.fill(result,0,result.length,(byte)0);
     // 用上一次的计算结果与输入的数据相乘
     for(int k=0;k<inputData.length;k++){
       for(int j=0;j<150;j++){
           // 两位相乘
           byte tempMul = (byte)(tempResult[j]*inputData[k]+result[j+k]);
           // 处理个位
           result[j+k]=(byte)(tempMul%10);
           // 处理进位
           pre=(byte)(tempMul/10);
          // 表示进到第几位
           int pp=1;
          // 处理进位
           while(pre>0){
              tempMul=(byte)(pre+result[j+k+pp]);
              result[j+k+pp]=(byte)(tempMul%10);
              pre=(byte)(tempMul/10);
              pp++;
            }

       }
     }
    }

              
    // 计算小数位
    int digits;
    if(index==-1)
        digits = 0 ;
    else
       digits = n*(data.substring(index+1).length());
              
   StringBuffer stringResult = new StringBuffer();
   if(index==-1){ // 没有小数点
       boolean b=false;
       for(int i=result.length-1;i>=0;i--){
          if(!b){ //前面都是0
              if(result[i]==0)
                continue;
              else
                b=true;
           }
        stringResult.append(result[i]);
       }
    }else{ // 有小数点
        boolean b=false;
        // 处理小数点之前
        for(int i=result.length-1;i>=digits;i--){
          if(!b){ //前面都是0
               if(result[i]==0)
                    continue;
                else
               b=true;
           }
          stringResult.append(result[i]);
         }
        stringResult.append(".");
        for(int i=digits-1;i>=0;i--){
            stringResult.append(result[i]);
        }
     }
     return stringResult.toString();
   }
 }