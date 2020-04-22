package ex200420;

public class ArrayAddMain {

	public static void main(String[] args) {
	
		int[] arr = { 9, 2, 3, 4, 5 };
		 addOneDArr(arr, 7);
		 
		int[][] two = new int[2][3];
			addOneDArr(arr, 7);
	}
	
	// 매개변수로 전달될 값의 크기만큼 증가
	public static int[] addOneDArr(int[] arr, int add) {
		for (int i = 0; i < arr.length; i++)
			arr[i] += add;
		return arr;
	}
	
	for (int i = 0; i < ref.length; i++)
		System.out.print(arr[i] + " ");
	

}
