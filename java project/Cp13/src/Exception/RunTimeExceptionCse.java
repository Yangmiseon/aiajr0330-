package Exception;

//ArrayIndexOutOfBoundsException 예외 발생처리
public class RunTimeExceptionCse {

	public static void main(String[] args) {

		
		
		try {
			int[] arr = new int[3];
			arr[2] = 20;
			System.out.println(arr[2]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Object obj = new int[10];
			String str = (String) obj;
		}catch (ClassCastException e) {
			System.out.println(e.getMessage());
			//I cannot be cast to java.lang.String형변환할수없다는 메세지가 나옴
		}
		
		try {
			int[] ar = new int[-10];
		} catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage()); //null 이라고 나옴 
		}
		
		try {
		String str = null;
		int len = str.length(); //참조변수를 찾으면됨 str이참조를 못하구있구나 하면됨
		} catch (NullPointerException e) {
			System.out.println(e.getMessage()); //null이라고 나옴
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
