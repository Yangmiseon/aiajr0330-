package PhoneBookVer_2;

import java.util.Scanner;

/*
  		전화번호 정보를 저장하는 기능만을 호함하는 클래스
  
  		1. 사용자로 부터 데이터를 받아서 인스턴스를 생성하고 반환 기능
  		2. 
 */

public class PhoneBookManager {
	
	
	PhoneInfor createInstanse() {//PhoneInfor를 생성하는 메서드정의 리턴은 변수인포
		
		
		//PhoneInfor를 참조하기 위한 변수 info선언
		//지역변수는 반드시 초기화 
		PhoneInfor info = null; 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("친구의 정보를 저장하기 위한 데이터 입력");
		System.out.println("이름을 입력해주세요. >> ");
		
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해 주세요. >> ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("생일을 입력해 주세요. >> ");
		String birthday = sc.nextLine();
		
		//사용자의 입력 데이터에 따라 인스턴스 생성 방법 구분
		if(birthday == null || birthday .trim().isEmpty()) {
			info = new PhoneInfor(name, phoneNumber);
		}else {
			info = new PhoneInfor(name, phoneNumber, birthday);
		}
		
		
		return info;
	}

}
