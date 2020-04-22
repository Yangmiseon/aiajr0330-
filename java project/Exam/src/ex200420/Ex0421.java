package ex200420;

public class Ex0421 {
	
	
	
		// 매개변수로 전달될 값의 크기만큼 증가
		public static int[] addOneDArr(int[] arr, int add) {
			for (int i = 0; i < arr.length; i++)
				arr[i] += add;
			return arr;
		}
		//2차 배열에 전달될 값을 크기만큼 증가
		public static int[][] addOneDArr1(int[][] brr1, int bdd1) {
			for (int x = 0; x < brr1.length; x++) {
				for(int y = 0; y<brr1[x].length; y++) {
					brr1[x][y] += bdd1;
				}
			}
			return brr1;
		}
		
		// 1차원 배열생성
		public static void main(String[] args) {
			int[] arr = { 8, 2, 3, 4, 5 };
			int[] ref;
			ref = addOneDArr(arr, 7);

			for (int i = 0; i < ref.length; i++)
				System.out.print(arr[i]+" ");
			System.out.println(); 

			System.out.println("---------------------------"); 
			
			
			//2차원 배열생성
			int[][] brr1 = {{1,2,3},
								{4,5,6}};
			int[][] bef1;
			bef1 = addOneDArr1(brr1, 2);

			for(int x=0; x<bef1.length; x++){ 

				for(int y=0; y<bef1[x].length; y++) 

					System.out.print(brr1[x][y]+" "); 

				System.out.println(""); 

				}
		}
}
		
		
		
	

