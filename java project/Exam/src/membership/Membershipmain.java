package membership;

public class Membershipmain {	

	public static void main(String[] args) {
		
		//회원 정보 5개를 저장 할 수 있는 배열을 생성
		//배열을 써야겠다고 생각하면 사이즈를 먼저 생각하기
		//멤버타입의 인스턴스의 참조값을 저장하는 메모리 공간
		//Member m1, m2, m3, m4,m5 처럼 5개 만든 것과 같다.
		Member[] members = new Member[5]; 
		
		//Member타입의 인스턴스 주소
		members[0] = new Member("coll", "didal", "dlkfj@lfj.com");
		members[1] = new Member("fs", "fghal", "hjkkj@lfj.com");
		members[2] = new Member("fghl", "jkjkl", "155fj@lfj.com");
		members[3] = new Member("jklo", "jyrel", "d24fj@lfj.com");
		members[4] = new Member("wrty", "erfhl", "d147j@lfj.com");
		
		
//		members[0].showInfo();
//		members[1].showInfo();
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo(); 반복문을 이용하면 일괄처리가능하다.
		
		for(int i = 0; i<members.length; i++) {
			System.out.println(members[i]);
			System.out.println("------------------------");

		}
		
		
		for(int i = 0; i<members.length; i++) {
			members[i].showInfo();
			System.out.println("------------------------");

		}
		
	
		Member member = new Member("coll", "didal", "dlkfj@lfj.com");
		member.showInfo();
		System.out.println("------------------------");
		System.out.println(member);//member를 넣으면 member.toString()호출
	}

}
