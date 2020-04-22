package PBVer_1;

public class PhoneInforMain {

	public static void main(String[] args) {
		
		PhoneInfor info = new PhoneInfor(null, null, "333");
		info.showInfo();
		
		info = new PhoneInfor("111", "222");
		info.showInfo();
		
	//	info.name = "333";
		//info.showInfo(); //이렇게 되면 두번째 값을 그대로 받아옴.데이터가값을유지못함.
		//PhoneInfor에 있는 변수에 private 해줘야함.
		//private해주고 났더니 오류가됨. 정보은닉으로 이 클래스에서 직접사용안됨
		//변수의 사용은 생성자를 통해 호출 여기 클래스에서도 볼수 있음
		//참조변수 info가 참조하고 있는 PhoneInfor의 showInfo메소드를 호출하려 입력한 값을 출력
	}
	

}
