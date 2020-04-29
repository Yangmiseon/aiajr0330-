package Wrapper;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		
		//Random rand = new Random();
		Random rand = new Random(12);
		rand.setSeed(System.currentTimeMillis());//제한시간기능, 어느정도의 시간이 소요되는지보는 메소드
		
		for(int i=0; i<10; i++) {
			
			//System.out.println(rand.nextBoolean());
			System.out.println(rand.nextInt(1000));
			//System.out.println(rand.nextDouble());
			//System.out.println(rand.nextInt(45)+1);//범위속 숫자만 출력1-46
			System.out.println("---------------------------");
		}

	}
	
	//Random rand = new Random(1);
	//숫자도 넣어줄수 있다. 난수 발생하는 패턴이 같아짐
	//게임할때 좋음. 각 스테이지 마다 같은 패턴이 나와야 하는데 그걸 할수 있음.

/*16
---------------------------
29
---------------------------
38
---------------------------
34
---------------------------
45
---------------------------
5
---------------------------
15
---------------------------
2
---------------------------
29
---------------------------
29
*/

}
