
public class LoopTest {

	public static void main(String[] args) {


		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		System.out.println("-------------------------------");
		
		

		
		for(int i=1; i<6; i++) {
			System.out.println(i);
			
		}
		System.out.println("-------------------------------");
		int i = 1;
		
		while(i<6) {
			System.out.println(i);
			i++; //중요 별5개! i값을 해주지 않으면 무한루프를 돌게됨.
		}
		System.out.println("-------------------------------");
		i=0;
		do {
			i++;
			System.out.println(i);
		}while(i<5);
		
	}

}
