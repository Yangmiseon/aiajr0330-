package test;

public class Boy2 {

	//구슬의 개수
	int numOfMarble;
	
	
	
	
	Boy2(int num) {//생성자는 초기화 목적
		
		numOfMarble = num;
		
	}
	
	//마블의 갯수를 설정하는 메서드
	void setMarble(int num) {
		numOfMarble=num;
	}
	
	//이제 게임을 해야함.
	void gameWin(Boy2 boy, int num) {

			
		numOfMarble+=num; //1의 객체가 이겼다면
		//반대로 상대방 은 마이너스 구슬
		boy.numOfMarble-=num;
	}
	
	void showData() {
		System.out.println("현재 보유한 구슬의 개수는 "+numOfMarble+"개 입니다.");
	}
	
	public static void main(String [] args) {
		//철수 생성
		Boy2 boy1=new Boy2(15);
		//영희 설정
		Boy2 boy2=new Boy2(9);
		
		//철수 15개 영희 9개 보유
		
		
		System.out.println("철수는 구슬을 "+boy1.numOfMarble+"영희는 구슬을 "+boy2.numOfMarble);
		
		
		//1차 게임에서 철수는 영희의 구슬2개를 획득
		System.out.println(">>>>>1차 게임에서 철수가 영희 구슬을 2개 획득한다.");
		
		boy1.gameWin(boy2, 2);
		
		System.out.println("철수");
		boy1.showData();
		System.out.println("영희"
				+ "");
		boy2.showData();
		
		System.out.println("철수는 구슬을 "+boy1.numOfMarble+"영희는 구슬을 "+boy2.numOfMarble);
		
		
		//2차에서는 영희가 철수의 구슬 7개 획득
		System.out.println(">>>>>2차 게임에서 영희가 철수 구슬을 7개 획득한다.");
		
		boy2.gameWin(boy1, 7);
		
		System.out.println("철수");
		boy1.showData();
		System.out.println("영희");
		boy2.showData();
		
		System.out.println("철수는 구슬을 "+boy1.numOfMarble+"영희는 구슬을 "+boy2.numOfMarble);
		
	
	
	
	
	
	
	
	}
}


