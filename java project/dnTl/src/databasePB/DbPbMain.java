package databasePB;

import java.util.Scanner;

public class DbPbMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 메뉴를 만든다.
		// void menu() {
		while (true) {
			System.out.println("1.모든 정보 보기");
			int select = sc.nextInt();
			switch (select) {
			case 1:// 모든 친구 보기
				DbPbManager.AllInfo();
				break;
			case 2:// 친구 정보 입력

				break;
			case 3:// 친구 정보 수정

				break;
			case 4:// 친구 정보 삭제

				break;
			case 5:// 친구 정보 검색

				break;

			}
		}

	}

}
