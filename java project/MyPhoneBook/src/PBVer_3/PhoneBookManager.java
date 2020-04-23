package PBVer_3;

import java.util.Scanner;

public class PhoneBookManager {
	
	 PhoneInfor[]pBooks;
	int cnt;
	Scanner pb = new Scanner(System.in);
	
	
	public PhoneBookManager(){
		pBooks=new PhoneInfor [100];
		cnt=0;
		
	}
	
	void addInfo(PhoneInfor info) {
		
		pBooks[cnt] = info;
		
		cnt++;
	}
	
	void addInfo() {
		
		//[]에 cnt++ 을 넣어주면 한줄줄일수있음
		pBooks[cnt] = createInfo();
		
		cnt++;
	}
	
	void showAll() {
		
		for(int i = 0; i<cnt; i++) {
			pBooks[i].showInfo();
			System.out.println("구분");
		}
	}
	
	
	PhoneInfor createInfo() {
		PhoneInfor info = null;
		
		
		
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

	
	int searchIndex(String name) {
		
		int searchIndex = -1;
		for(int i =0; i<cnt; i++) {
			if(pBooks[i].checkName(name)) {
				searchIndex = i;
				break;
			}
		}
		
		return searchIndex;
		
	}

	public void searchInfo() {
		
		System.out.println("찾을 이름 입력");
		String name = pb.nextLine();
		
		int searchIndex = searchIndex(name);
		if(searchIndex<0) {//검색결과가 없을 경우
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		}else {
			pBooks[searchIndex].showInfo();
		}
		
	}

	public void deleteInfo() {
		
		System.out.println("삭제 이름 입력");
		String name = pb.nextLine();
		
		int searchIndex = searchIndex(name);
		
		if(searchIndex<0) {//검색결과가 없을 경우
			System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
		}else {
			for(int i=searchIndex; i<cnt-1; i++) {
				pBooks[i] = pBooks[i+1];
			}
			cnt--;
			System.out.println("요청하신 이름의 정보를 삭제했습니다.");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
