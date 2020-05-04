package battle;

import java.util.Scanner;

public class Battle {
	
	Scanner bt = new Scanner(System.in);
	
	
	
	void turnCheck() {
		
		//던전불러오고
		System.out.println();//괴물+"나타났습니다.")
		System.out.println("1. 공격, 2. 회피");
		int playerNum = bt.nextInt();
		
		
		switch(playerNum) {
			case 1:
				System.out.println(); //플레이어가 공격을 합니다.
				break;
			
			case 2:
				System.out.println();//플레이어가 회피합니다.
				break;
		}
		
		//누가 이기고 졌는지 체크
		
		//공격하는거
	
		//회피하는거
			
		
	}
	
	void choicePlayerMovement (int dmg) {
		for
	}
	
}
//choicePlayerMovement
//choiceMonsterMovement
//battleResult