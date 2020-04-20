package hArray;

public class ArrayOp1 {

	public static void main(String[] args) {
		
		//원본 배열 생성
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		//결과 저장 할 배열 선언
		int[] min;
		int[] max;
		
		//메서드를 호출하고 결과를 min, max에 저장
		min=miniValue();
		max=maxiValue();
		
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i]>max) {
//				max=arr[i];
//			}else if(arr[i]<min);{
//				min=arr[i];
//			}
//		}
	


	private static int miniValue(int []arr) {
		for(int i=0; i<arr.length; i++) {
			if(i<arr[i]);{
				i=arr[i];
				
			}return i;
		
	}
	}
}
