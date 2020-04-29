package Wrapper;

import java.util.StringTokenizer;

public class TokenTest {

	public static void main(String[] args) {

		String phoneNumber="TEL 82-02-997-205    9             test";
		
		StringTokenizer st1 = new StringTokenizer(phoneNumber);
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		
		StringTokenizer st2 = new StringTokenizer(phoneNumber, " -", true);
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		
//String phoneNumber="TEL 82-02-997-205    9             test";
//		
//		StringTokenizer st1 = new StringTokenizer(phoneNumber);
//		while(st1.hasMoreTokens()) {
//			System.out.println(st1.nextToken());
//		}
		/*TEL
82-02-997-205
9
test
*/
		
		
		/*StringTokenizer st2 = new StringTokenizer(phoneNumber, "-");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		 * TEL 82
02
997
205    9             test
		 * 
		 */
	}

}
