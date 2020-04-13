
public class WhileBasic {

	public static void main(String[] args) {
		//한번은 출력해야 할 때, 조건에 맞지 않아도 한번은 출력함.
		//메뉴판같은거 만들때 사용

		int num=6;
		
		do {
			System.out.println("I like JAVA" + num);
			num++;
		}	while(num<6);

	}

}

