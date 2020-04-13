
public class Whileex1 {

	public static void main(String[] args) {

		int n =0;
		for (int i =1; i<=1000; i++) {
			if(i%2!=0 || i%7!=0) {
				continue;
				
			}
			System.out.println("2와7의 배수 : " +i);
			n= n+i;
			
			
	}
		
			System.out.println(n);
}
}