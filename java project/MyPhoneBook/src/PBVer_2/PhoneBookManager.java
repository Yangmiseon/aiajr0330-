package PBVer_2;

import java.util.Scanner;

public class PhoneBookManager {
	
	PhoneInfor createInfo() {
		PhoneInfor info = null;
		
		Scanner pb = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		String name = pb.nextLine();
		
		System.out.println("전화번호를 입력하세요");
		String phoneNumber = pb.nextLine();
		
		System.out.println("생일을 입력하세요");
		String birthday = pb.nextLine();
		
		if(birthday == null||birthday.trim().isEmpty()) {
			info = new PhoneInfor(name, phoneNumber);
		}else {
			info = new PhoneInfor(name,phoneNumber, birthday);
		}
		
		
		
		
		return info;
	}

}
