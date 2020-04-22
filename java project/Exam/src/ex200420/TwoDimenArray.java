package ex200420;

public class TwoDimenArray {

	public static void main(String[] args) {
		
		
		// 1차원 배열 선언, 생성
		int[][] arr = new int[3][4];
		
		//arr[행의 위치][1차원 배열의 인덱스]
//		행을 돌리는거.args 행하고 일차원. 행하고 이차원
//		이차원 배열은 1차원 배열의 갯수만큼.
		System.out.println(arr.length); //행의 사이즈 반환 3
		System.out.println(arr[0].length); //열의 사이즈 반환4
		
		
		
		
		//요소들 대입
		for(int i=0; i<arr.length; i++) {
			
			//
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=i+j;
				
				
			}
			
			System.out.println();
		}
		
		//2차원 배열의 요소 참조 반복 방법
		//arr행의 0~2까지 행의 반복
		for(int i=0; i<arr.length; i++) {
			
			//1차원 배열의 요소 참조 반복 열의 반복
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" \t");
				
			}
			
			System.out.println();
		}

	}

}
