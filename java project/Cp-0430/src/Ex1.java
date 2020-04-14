
public class Ex1 {

	public static void main(String[] args) {
		//1부터 10까지의 합
		//반복. +1씩 
		int sum=0; //값이 들어가 있으면 왜곡이 생김. 합을 담는 변수

		for(int i=1; i<=10; i++) { //i<11로 사이즈를 해줘도됨
			
			sum=sum+i;
			
	}
		System.out.println("1부터 10까지 합은: " +sum);
		
		
		int i=1; //값이 들어가 있으면 왜곡이 생김. 합을 담는 변수
		sum = 0;
		while(i<=10) {
			sum += i;
			i++;
			System.out.println(sum);
		
}
		System.out.println("합은 : " +sum);
	}
		
		
		public static void main1(String[] args) {	
		
		
			
			int i =0;
			while (i%2==0 && i%7==0) {
				if(i<=100) {
					break;
				}
				System.out.println(i);
					i++;
			
	}
		
		
}
}
