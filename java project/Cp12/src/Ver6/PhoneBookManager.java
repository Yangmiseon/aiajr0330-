package Ver6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//PhoneInfo타입의 배열로 친구들의 정보를 저장, 수정, 삭제, 검색, 출력 기능을 해주는 클래스
public class PhoneBookManager {
	
	
	//생성자 접근제어 지시자
	private static PhoneBookManager manager = new PhoneBookManager(100);
	public static PhoneBookManager getInstance() {
		
		return manager;
	}
	
	//리스트 생성
	List<PhoneInfo> books;
	Scanner  kb;
	
	//생성자를 통해서 배열생성, 요소의 개수 초기화
	private PhoneBookManager(int num){

		books = new ArrayList<>();
		kb = new Scanner(System.in);
	}
	

	void addInfo(PhoneInfo info) {
	
		books.add(info);
	}
	
	//2-2사용자로부터 받은 데이터로 인스턴스 생성>>분기필요
	void createInfo () {
	

	while(true) {
		
		
		System.out.println(""+MenuNum.INSERT_UNIV+". 대학  "
				+ ""+MenuNum.INSERT_COMPANY+". 회사  "+MenuNum.PRINT_CAFE+". 동호회");
		System.out.println("번호를 선택해 주세요.");
		int select = 0;
		
		try {
		 select = Integer.parseInt(kb.nextLine());
		 if(!(select>0 && select<7)) {
				System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
			continue;
			}
		}catch (NumberFormatException e){
			System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
			continue;
		}catch (RuntimeException e){
			System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
			continue;
		}

		
		//2.2.1기본 정보 수집 : 이름, 전번, 주소, 이메일
		System.out.println("이름을 입력해 주세요");
		String name = kb.nextLine();
		
		System.out.println("전화번호를 입력해 주세요");
		String phoneNumber = kb.nextLine();
		
		System.out.println("주소를 입력해 주세요");
		String addr = kb.nextLine();
		
		System.out.println("이메일을 입력해 주세요");
		String email = kb.nextLine();
		
		
		PhoneInfo info = null;
		
		switch (select) {
			
		case MenuNum.INSERT_UNIV://2.2.3 대학 클래스로 인스턴스 생성
			System.out.println("전공(학과)를 입력해주세요");
			String major = kb.nextLine();
			System.out.println("학년을 입력해 주세요");
			String grade = kb.nextLine();
			info = new PhoneUnivInfor(name, phoneNumber, addr, email, major, grade);
			break;
			
		case MenuNum.INSERT_COMPANY://2.2.4 회사 클래스로 인스턴스 생성
			System.out.println("회사이름을 입력해 주세요");
			String company = kb.nextLine();
			System.out.println("부서를 입력해 주세요");
			String dept = kb.nextLine();
			System.out.println("직무(직급) 입력해 주세요");
			String jop = kb.nextLine();
			info = new PhoneCampanyInfo(name, phoneNumber, addr, email, company, dept, jop);
			break;
			
		case MenuNum.PRINT_CAFE://2.2.5 동호회 클래스로 인스턴스 생성
			System.out.println("동호회 이름을 입력해 주세요");
			String cafeName = kb.nextLine();
			System.out.println("닉네임을 입력해 주세요");
			String nickName = kb.nextLine();
			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		
		}	
		//2.3 생성된 인스턴스를 배열에 저장
		addInfo(info);
	break;	
	}
	}
	
	
	//3.배열에 정보 전체 출력
	void showAllInfo() {
		System.out.println("전체 정보를 출력합니다.===========");
		for(int i = 0; i<books.size(); i++) {
			books.get(i).showAllInfo();
			System.out.println("-------------------------------------------");
		}
		
		
	}
	
	//인덱스 기준 찾기기능 
	int searchIndex(String name) {
		
		int searchIndex = -1;
		
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).name.equals(name)) {
				searchIndex=i;
				break;
			}
		}
		return searchIndex;
	}
	
	//4.배열에 정보 검색 : 이름기준
	void showInfo() {
		
		System.out.println("검색하실 이름을 입력하세요");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("찾으시는 이름이 없습니다.");
		}else {
			System.out.println("------------------------------");	
			books.get(index).showAllInfo();
		}		
				
	}
	
	//5.베열에 정보 삭제 : 이름기준
	void deleteInfo() {
		System.out.println("삭제하고자 하는 이름을 입력해주세요");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0){
			System.out.println("찾으시는 이름이 없습니다.");
		}else {
				books.remove(index);
			}
		}		
		

	
	//6.배열에 정보 수정 : 이름기준
	void editInfo() {
		
		System.out.println("변경하고자 하는 이름을 입력해주세요");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		
		if(index<0) {
			System.out.println("검색결과가 없습니다.");
			return;//여기 밑으로 처리 되지 않도록 리턴
		}else {
			
			//이름기준으로 받아야 하니 이름을 고정
			String editname = books.get(index).name;			
			System.out.println("수정 데이터 입력을 시작합니다.");
			System.out.println("이름은 "+editname+"입니다.");//어떤 데이터를 수정하는지 보여주느거
			System.out.println("전화번호를 입력해주세요");
			String phoneNumber = kb.nextLine();
			System.out.println("주소를 입력해주세요");
			String addr = kb.nextLine();
			System.out.println("이메일을 입력해주세요");
			String email = kb.nextLine();
			
			PhoneInfo info = null;
			
			
			if(books.get(index) instanceof PhoneUnivInfor) {
				System.out.println("전공을 입력해 주세요");
				String major = kb.nextLine();
				System.out.println("학년을 입력해 주세요");
				String grade = kb.nextLine();
				
				info = new PhoneUnivInfor(editname, phoneNumber, addr, email, major, grade);		
				
			}else if(books.get(index) instanceof PhoneCampanyInfo) {
				System.out.println("회사이름을 입력해 주세요");
				String company = kb.nextLine();
				System.out.println("부서를 입력해 주세요");
				String dept = kb.nextLine();
				System.out.println("직무을 입력해 주세요");
				String jop = kb.nextLine();
				
				info = new PhoneCampanyInfo(editname, phoneNumber, addr, email, company, dept, jop);
			
			}else if(books.get(index) instanceof PhoneCafeInfo) {
				System.out.println("동호회이름을 입력해 주세요");
				String cafeName = kb.nextLine();
				System.out.println("닉네임을 입력해 주세요");
				String nickName = kb.nextLine();
				
				info = new PhoneCafeInfo(editname, phoneNumber, addr, email, cafeName, nickName);
			}
		
			books.remove(index);
			books.add(index, info);
		}
		
	}





}




