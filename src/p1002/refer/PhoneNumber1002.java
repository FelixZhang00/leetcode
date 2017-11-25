import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class PhoneNumber1002 {

	private String oldStr[];        //原始字符串
	private String newStr[];        //数字大写字母字符串
	private String phoneStr[]; 		//电话字符串
	private HashMap<String,Integer> phoneNum; //存放标准的电话字符串，及其个数
	private int strNum;            //字符串个数
	
	// 构造函数，初始化字符串个数，以及字符串
	public PhoneNumber1002(){
		int i=1;
		String num_str,str_str;
		String str[];
		
		try{
			BufferedReader num_in=new BufferedReader(new InputStreamReader(System.in));
			num_str=num_in.readLine();
			this.strNum=Integer.parseInt(num_str);	
			
			str=new String[strNum];
			while(i<=strNum){
				BufferedReader str_in=new BufferedReader(new InputStreamReader(System.in));
				str_str=str_in.readLine();
				str[i-1]=str_str;
				i++;
			}
			this.oldStr=str;
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	//这个是完成对初始化字符串的的转换，即对其进行简单的提取数字和大写字母
	public void opInitalConvert(){
		int i;
		//先分配numStr个字符串指针空间
		String[] newStr=new String[oldStr.length];
		//然后为每个指针空间分配字符串
		for(i=0;i<strNum;i++)  
			newStr[i]=new String("");
		Pattern pattern=Pattern.compile("[0-9A-Z]+");
		for(i=0;i<oldStr.length;i++){
			Matcher matcher=pattern.matcher(oldStr[i]);
			while(matcher.find()){
				newStr[i]=newStr[i]+matcher.group();
			}		
		}
		this.newStr=newStr;
	}
	
	//完成对最后数字和大写字母字符串的 最后转换，即变成标准的电话号码字符串
	public void opLastConvert(){
		int i,j;
		String[] phoneStr=new String[strNum];
		char[] charOfstr;
		for(i=0;i<strNum;i++){
			charOfstr=newStr[i].toCharArray();
			for(j=0;j<charOfstr.length;j++){
				if (charOfstr[j]=='A'|charOfstr[j]=='B'|charOfstr[j]=='C')
					charOfstr[j]='2'; 
		        else if (charOfstr[j]=='D'|charOfstr[j]=='E'|charOfstr[j]=='F')
					charOfstr[j]='3';
		        else if (charOfstr[j]=='G'|charOfstr[j]=='H'|charOfstr[j]=='I')
					charOfstr[j]='4';
		        else if (charOfstr[j]=='J'|charOfstr[j]=='K'|charOfstr[j]=='L')
					charOfstr[j]='5';
		        else if (charOfstr[j]=='M'|charOfstr[j]=='N'|charOfstr[j]=='O')
					charOfstr[j]='6';
		        else if (charOfstr[j]=='P'|charOfstr[j]=='R'|charOfstr[j]=='S')
					charOfstr[j]='7';
		        else if (charOfstr[j]=='V'|charOfstr[j]=='T'|charOfstr[j]=='U')
					charOfstr[j]='8';
		        else if (charOfstr[j]=='W'|charOfstr[j]=='X'|charOfstr[j]=='Y')
					charOfstr[j]='9';				
			}
			//phoneStr[i]=charOfstr.toString();
			phoneStr[i]=new String(charOfstr);
			phoneStr[i]=phoneStr[i].substring(0,3) + "-" + phoneStr[i].substring(3);
		}
		this.phoneStr=phoneStr;
	}
	
	//统计并计算，各个字符串的条数
	public void calStr(){
		int i;
		Integer numValue;
		phoneNum=new HashMap<String,Integer>();
		for(i=0;i<phoneStr.length;i++){
			if(!phoneNum.containsKey(phoneStr[i]))
				phoneNum.put(phoneStr[i],1);
			else{
				numValue=phoneNum.get(phoneStr[i]);
				phoneNum.remove(phoneStr[i]);
				phoneNum.put(phoneStr[i],numValue.intValue()+1);
			}
		}
	}
	
	//返回字符串个数
	public int retNumOfstr(){
		return this.strNum;
	}
	
	//返回原始字符串
	public String[] retOldStr(){
		return this.oldStr;
	}
	
	//返回经过初步处理后的数字和大写字母字符串
	public String[] retNewStr(){
		return this.newStr;
	}
	
	//返回经过最终处理的电话号码串
	public String[] retPhoneStr(){
		return this.phoneStr;
	}
	
	//返回经过最终处理的电话号码串
	public HashMap<String,Integer> retPhoneNum(){
		return this.phoneNum;
	}
	
	//test 主函数 PhoneNumber1002
	public static void PhoneNumber1002(String[] args) {
		PhoneNumber1002 testphone=new PhoneNumber1002();
		String[] oldstr,newstr,phonestr;
		HashMap<String,Integer> phonenum;
		
		///////////////////////test////////////////////////
		int i;	
		oldstr=testphone.retOldStr();
		for(i=0;i<oldstr.length;i++)
			System.out.println(oldstr[i]);
		
		testphone.opInitalConvert();	
		
		newstr=testphone.retNewStr();
		for(i=0;i<newstr.length;i++)
			System.out.println(newstr[i]);	
		///////////////////////test////////////////////////	
		
		testphone.opLastConvert();
		
		phonestr=testphone.retPhoneStr();
		for(i=0;i<phonestr.length;i++)
			System.out.println(phonestr[i]);
		
		testphone.calStr();
		phonenum=testphone.retPhoneNum();
		Collection<Integer> valueNum=phonenum.values();
		Iterator<Integer> it=valueNum.iterator();
		int k=0;
		while(it.hasNext()){
			int tmp;
			tmp=it.next().intValue();
			if(tmp==1)
				k++;
		}
		if(valueNum.size()==k)
			System.out.println("No duplicates.");
		else{
			Set<String> phoneNumber=phonenum.keySet();
			Iterator<String> it_key=phoneNumber.iterator();
			int dhhmsl;
			String dhhm="";
			while(it_key.hasNext()){
				dhhm=it_key.next();
				dhhmsl=phonenum.get(dhhm).intValue();
				if(dhhmsl!=1)
					System.out.println(dhhm+" "+dhhmsl);
			}
		}
	}
}