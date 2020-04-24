package Friend;

import java.util.Scanner;

//입력하고 출력하는 기능 만들것임
//상세출력과 기본출력 메뉴를 나누어 출력
public class FriendInfoHandler {
	
	//Friend타입의 정보를 저장할 배열을 가진다.
	//친구 정보를 저장하는 기능
	//친구 정보의 기본 정보 출력기능
	//친구의 친구정보 상세정보 출력기능
	
	private Friend[] myFriends; //Friend타입의 배열 선언
	private int numOfFriend; //저장된 친구의 정보개수
	
	Scanner kb;
	
	//초기화>생성자
	//저장공간(사이즈) 크기를 받아서 배열 생성하는 변수 넘
	FriendInfoHandler(int num){
		myFriends = new Friend[num];
		numOfFriend = 0;
		 kb = new Scanner(System.in);
	}
	
	//친구의 정보를 저장하는 기능
	//1. 배열에 저장
	//2.사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	
	//1.배열에 저장하는 기능
	void addFriendInfo(Friend f) {
		myFriends[numOfFriend]=f;
		numOfFriend++;
	}
	
	
	//2.사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	//분기해서 인스턴스 만드는 기능 아름답게 만드는거 고민해보기
	//high프렌드/유니브프렌드
	void addFriend(int choice) {
		
		
		//기본정보를 받기
		//생성자랑비슷하게 변수만들면 편함
		System.out.println("이름 입력하기");
		String name = kb.nextLine();
		
		System.out.println("전화번호 입력하기");
		String phoneNum = kb.nextLine();
		
		System.out.println("주소 입력하기");
		String addr = kb.nextLine();
		
		Friend friend = null; //프렌드 타입의 프렌드변수선언, 초기화는 널, 참조변수
			
		if(choice == 1) {
			//1일때 정보 받기 - 직업
			System.out.println("직업 입력하기");
			String work =  kb.nextLine();
			
			//하이프렌드 인스턴스 생성
			friend = new HighFriend(name, phoneNum, addr,work);
			
		}else {
			//2일때 정보 받기
			System.out.println("전공 입력하기");
			String major = kb.nextLine(); 
			System.out.println("학년(숫자) 입력하기");
			String grade = kb.nextLine();
			Integer.parseInt(grade);//parseInt 문자열을 받아 숫자로 반환해주는 메서드
		
			//유니브 프렌드 정보받기
			friend = new UnivFriend(name, phoneNum, addr, major, Integer.parseInt(grade));
			
		}
		
		//addFriendInfo호출
		addFriendInfo(friend);
		
	}
	

		//친구의 기본 정보 출력 기능
		void showAllSimpleData() {
			
			System.out.println("====친구의 기본 정보를 출력합니다.====");
			
			for(int i=0; i<numOfFriend; i++) {
				myFriends[i].showBasicInfo();
				System.out.println("-------------------------------------------");
			}
		}
		
		//친구의 상세정보 출력 기능
		void showAllData() {
			
			System.out.println("++++친구의 모든 정보를 출력합니다.++++");
			
			for(int i=0; i<numOfFriend; i++) {
				myFriends[i].showData();//오버라이딩한 정보들이게 핵심!!!
				System.out.println("-------------------------------------------");
			}
		}
		
}


























