
public class Ex3 {

	public static void main(String[] args) {
	//1-1
	int x = 0;
	if(10<x && x<20) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	
	
	//1-2
	char ch = 'a';
	if(' '!=ch && '\t'!=ch) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	
	//1-3
	char ch = 'x';
	if('x'==ch || 'X'==ch) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	
	
	//1-4
	char ch = '1';
	if('0'<=ch && ch<='9') {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	
	//1-5
	char ch = 'x';
	if(65<=(int)ch && ch<=(int)90) {
		System.out.println("true");
	}else if ((int)97<=ch && ch<=(int)122) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	
	//1-6
	int year = 2008;
	if(year%400==0) {
		System.out.println("true");
	}else if (year%4==0 && year%100!=0) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	
	//1-7
	
	
	
	//1-8
	
	
	
	
	
	//2
	int i=1;
	int sum = 0;
	
	while(i<=20) {
			
		if(i%2!=0&&i%3!=0)
		
		System.out.println(i);
		
		i++;
		sum=sum+i;	
	

	}
	
	
	System.out.println(sum);
	
	//3
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
}