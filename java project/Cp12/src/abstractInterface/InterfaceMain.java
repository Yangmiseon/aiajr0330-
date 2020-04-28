package abstractInterface;

import java.util.Scanner;

public class InterfaceMain {

	public static void main(String[] args) {
		System.out.println("요일을 선택해주세요");
		System.out.println("1.월, 2.화, 3.수, 4.목, 5.금, 6.토, 7.일");
		
		Scanner kb = new Scanner(System.in);
		switch(kb.nextInt()) {
		case week.MON:
			System.out.println("월요일 입니다.");
			break;
		case week.TUE:
			System.out.println("화요일 입니다.");
			break;
		case week.WED:
			System.out.println("수요일 입니다.");
			break;
		case week.THU:
			System.out.println("목요일 입니다.");
			break;
		case week.FRI:
			System.out.println("금요일 입니다.");
			break;
		case week.SAT:
			System.out.println("토요일 입니다.");
			break;
		case week.SUN:
			System.out.println("일요일 입니다.");
			break;
		}
	}

}
