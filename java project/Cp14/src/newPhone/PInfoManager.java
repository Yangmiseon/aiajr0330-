package newPhone;

import java.util.Scanner;

public class PInfoManager {
	
	PInfo[]pBooks;
	int cnt;
	
	PInfoManager() {
		pBooks = new PInfo[100];
		cnt = 0;
	}
	
	void addInfo(PInfo info) {
		
		pBooks[cnt] = create();
		cnt++;
	}
//	
//	void addInfo() {
//		
//		//[]에 cnt++ 을 넣어주면 한줄줄일수있음
//		pBooks[cnt] = create();
//		
//		cnt++;
//	}
//	
	
	
	
	PInfo create() {
		
		PInfo info = null;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		String name = kb.nextLine();
		
		System.out.println("전화번호를 입력하세요");
		String pNum = kb.nextLine();
		
		System.out.println("주소를 입력하세요");
		String add = kb.nextLine();
		
		System.out.println("생일을 입력하세요");
		String birthday = kb.nextLine();
				
		info = new PInfo(name, pNum, add, birthday);
		return info;
	}
	
	void showAll() {
		
		for(int i = 0; i<cnt; i++) {
			pBooks[i].show();
			System.out.println("구분");
		}
	}

}
