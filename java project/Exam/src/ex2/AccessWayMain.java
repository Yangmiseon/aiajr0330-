package ex2;

public class AccessWayMain {

	public static void main(String[] args) {


		System.out.println(AccessWay.num);
		AccessWay.num++; //액세스 안에 있는 넘에 넘을 ++
		System.out.println(AccessWay.num);
		
		AccessWay ac = new AccessWay();
		System.out.println(ac.num2);
		System.out.println(ac.num);
		

	}
	

}
