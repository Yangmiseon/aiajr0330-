package PhoneBookVer_1;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneInfor info = new PhoneInfor("손흥민", "01023655698", "2000.04.22");
		info.showInfo();
		
//		info.name = "박지성"; 
		//폰북 클래스에서 변수앞에 private 안해주면 이렇게했을때 손흥민꺼가져와 이름을 바꿈
		
		info = new PhoneInfor("박지성", "01023457852");
		info.showInfo();
		
	}

}


//여기서 폰인포클래스를 가져와 출력