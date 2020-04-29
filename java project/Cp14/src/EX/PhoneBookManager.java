package EX;

import java.util.InputMismatchException;
import java.util.Scanner;

//PhoneInfo타입의 배열로 친구들의 정보를 저장, 수정, 삭제, 검색, 출력 기능을 해주는 클래스
public class PhoneBookManager {
	
	
	//생성자 접근제어 지시자
	private static PhoneBookManager manager = new PhoneBookManager(100);
	public static PhoneBookManager getInstance() {
		//PhoneBookManager이메서드로 참조값을 가져와야하니까 스태틱처리
		//누구나 사용할수있도록 public처리
		return manager;
	}

	//1. 배열 선언
	PhoneInfo[] books; // 배열변수인스턴스 널값이 들어가있는것. 배열의 주소값을 가리키고 있다.
	//배열에 저장된 요소의 개수
	int numOfInfo;
	Scanner  kb;
	
	//생성자를 통해서 배열생성, 요소의 개수 초기화
	PhoneBookManager(int num){
		books = new PhoneInfo[num];
		//요소 개수의 초기화
		numOfInfo = 0;
		kb = new Scanner(System.in);
	}
	
	
	
	//2.배열에 정보저장
	//2-1배열에 추가
	//2-2사용자로부터 받은 데이터로 인스턴스 생성
	
	//2-1배열에 추가
	//폰인포 타입을 저장해주는 목적
	//매개변수통해 참조값받기-PhoneInfo info
	void addInfo(PhoneInfo info) {
		//배열에 numOfInfo 숫자>> index로 참조값을 저장
		books[numOfInfo] = info;
		//저장하고 증가시키기
		numOfInfo++;
	}
	
	//2-2사용자로부터 받은 데이터로 인스턴스 생성>>분기필요
	void createInfo () {
	

	
		
		int select = 0;
		
		while(true) {
			System.out.println(""+MenuNum.INSERT_UNIV+". 대학  "
					+ ""+MenuNum.INSERT_COMPANY+". 회사  "+MenuNum.PRINT_CAFE+". 동호회");
			System.out.println("번호를 선택해 주세요.");
			
			try {
			select = kb.nextInt();
			
			if(!(select>0 && select<4)) {
				BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 범위입니다.\n 확인후 입력해 주세요.");
				//System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
				throw e;//강제예외발생
				
			}break;
			}catch (InputMismatchException e){
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				manager.kb.nextLine();//버퍼방지
				continue;
			}catch (BadNumberException e){//강제예외발생시 처리해주는거
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				manager.kb.nextLine();//버퍼방지
				
				continue;
			}catch (Exception e){
				System.out.println("정상적인 입력이 아닙니다. 다시 선택해 주세요.");
				manager.kb.nextLine();//버퍼방지
				
				continue;
			}finally {//이렇게해주면 다 비워줌
			manager.kb.nextLine();
			}
		 
		
		 
		}
		 
		 
//		int select = kb.nextInt();
//		kb.nextLine();
		//사용자선택번호
//		while(true) {//이위치에 있으면 처음메뉴가 안나옴
			
	
		PhoneInfo info = null;
		String name = null, phoneNumber=null, addr=null, email=null;
		//int select = Integer.parseInt(kb.nextLine());
		while(true) {
		//2.2.1기본 정보 수집 : 이름, 전번, 주소, 이메일
		System.out.println("이름을 입력해 주세요");
		name = kb.nextLine();
		
		System.out.println("전화번호를 입력해 주세요");
		phoneNumber = kb.nextLine();
		
		System.out.println("주소를 입력해 주세요");
		addr = kb.nextLine();
		
		System.out.println("이메일을 입력해 주세요");
		email = kb.nextLine();
		
		try {
		//예외
		//trim()공백처리해주는 메서드
		if(name.trim().isEmpty()||phoneNumber.trim().isEmpty()||addr.trim().isEmpty()||email.trim().isEmpty()) {
			StringEmptyException e = new StringEmptyException();
			throw e;
		}
		}catch (StringEmptyException e) {
			System.out.println("기본정보는 공백없이 모두 입력해주세요.");
			System.out.println("다시 입력해 주세요/n");
			continue;
		}
		
		break;
		}
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
			
			//예외처리할땐 인스턴스 생성전인 이자리에 해준다.
			
			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		
//			System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
//			return; 정보 다받아놓고 다시 입력하라고하는 것보다 앞에서 먼저 걸러주는 흐름이 좋음.
		}	
		
		
		//2.3 생성된 인스턴스를 배열에 저장
		addInfo(info);
}
		
	
	
	//3.배열에 정보 전체 출력
	void showAllInfo() {
		//반복문사용 for문  : 반복의 횟수 지정이 가능 >>numOfInfo이용
		//for each문 - 반복의 횟수를 사용자가 정할수없음. 마지막중복데이터가보일것임, 현재프로그램은 사용불가
		System.out.println("전체 정보를 출력합니다.===========");
		for(int i = 0; i<numOfInfo; i++) {
			books[i].showAllInfo();
			System.out.println("-------------------------------------------");
		}
		
	}
	//인덱스 기준 찾기기능 
	int searchIndex(String name) {
		int searchIndex = -1; //정상적인 인덱스 값은 0이상의 값이 나온다. 찾지 못했을때 구분값은 -1
		//배열의 반복으로 name값을 비교해서 인덱스 값을 찾는다.
		for(int i = 0; i<numOfInfo; i++) {
			if(books[i].name.equals(name)) {
				searchIndex = i;
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
			books[index].showAllInfo();
		}		
				
	}
	
	//5.베열에 정보 삭제 : 이름기준
	void deleteInfo() {
		System.out.println("삭제하고자 하는 이름을 입력해주세요");
		String name = kb.nextLine();
		
		int index = searchIndex(name);
		if(index<0) {
			System.out.println("찾으시는 이름이 없습니다.");
		}else {//있다면 시프트하기. 넘오브만큼 1감소하기
			//삭제 위치에서 왼쪽으로 시프트처리
			for(int i=index; i<numOfInfo-1; i++) {
				
				books[i]=books[i+1];
			}
			numOfInfo--;//삭제가 되었으므로 요소의 개수-1
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
			String editname = books[index].name;
			
			System.out.println("수정 데이터 입력을 시작합니다.");
			System.out.println("이름은 "+editname+"입니다.");//어떤 데이터를 수정하는지 보여주느거
			System.out.println("전화번호를 입력해주세요");
			String phoneNumber = kb.nextLine();
			System.out.println("주소를 입력해주세요");
			String addr = kb.nextLine();
			System.out.println("이메일을 입력해주세요");
			String email = kb.nextLine();
			
			PhoneInfo info = null;
			
			
			if(books[index] instanceof PhoneUnivInfor) {
				System.out.println("전공을 입력해 주세요");
				String major = kb.nextLine();
				System.out.println("학년을 입력해 주세요");
				String grade = kb.nextLine();
				
				info = new PhoneUnivInfor(editname, phoneNumber, addr, email, major, grade);		
				
			}else if(books[index] instanceof PhoneCampanyInfo) {
				System.out.println("회사이름을 입력해 주세요");
				String company = kb.nextLine();
				System.out.println("부서를 입력해 주세요");
				String dept = kb.nextLine();
				System.out.println("직무을 입력해 주세요");
				String jop = kb.nextLine();
				
				info = new PhoneCampanyInfo(editname, phoneNumber, addr, email, company, dept, jop);
			
			}else if(books[index] instanceof PhoneCafeInfo) {
				System.out.println("동호회이름을 입력해 주세요");
				String cafeName = kb.nextLine();
				System.out.println("닉네임을 입력해 주세요");
				String nickName = kb.nextLine();
				
				info = new PhoneCafeInfo(editname, phoneNumber, addr, email, cafeName, nickName);
			}
//			else //저장된 인스턴스가 기본, 대학, 회사, 동호회인지에 따라 바뀌어야함
//				if(books[index] instanceof PhoneInfo) {
//					
//					info = new PhoneInfo(editname, phoneNumber, addr, email);
//			}		
			//배열에 새로운 인스턴스를 저장
			books[index] = info;
		}
	}





}




























