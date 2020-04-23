package Ex;

public class BusonessMan extends Man {
	
	
	String company;
	String position;
	
	
	
	//조상클래스의 생성자가 있다면 자손클래스의 생성자에서 
	//값을 받아 조상클래스의 생성자를 호출해서 초기화 해준다.
	//초기화방법1
	BusonessMan(String name, String company, String position) {
		super(name);
		this.company=company;
		this.position = position;
		// TODO Auto-generated constructor stub
	}
	
	void tellYourInfo() {
//		super.tellYourName(); 밑에꺼랑 같은 내용
		tellYourName();//상속했으니 멤버라 이렇게도 가능함
		System.out.println("나의 직장 이름은 " + company + "입니다.");
		System.out.println("나의 직급은 " + position + "입니다.");

	}
	

	}

/*초기화방법2.
 * BusonessMan(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	*/
