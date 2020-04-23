package Car;

public class Car {
	
	String color;
	int door;
	
	void drive() {
		System.out.println("운전");
		
	}
	
	void stop() {
		System.out.println("멈춤");
	}
	
	public static void main(String[] args) {
		
		Car car = null;
		Fireengine fe1 = new Fireengine();
		Fireengine fe2 = null;
		Ambulance am = null;
		
		
			fe1.water();
			car = fe1;//형변환. (Car)생략할수있다.
			//car.water(); 사용할수없음.
			
			fe2 = (Fireengine)car;//넘어갈수없으니 형변환해줘야 함
//			am = (Ambulance)car;
//			am.siren();//오류표시는 없으나 넘어가지 않음. 형변환여부를 판단하기 위해 인스턴스오브
//			System.out.println(car instanceof Ambulance);//이렇게 확인할 수 있음.
			
			if (car instanceof Ambulance) {
				am = (Ambulance)car;
				am.siren();

			}
			
	}

}


class Fireengine extends Car {
	
	void water() {
		System.out.println("물뿌리기");
	}
}


class Ambulance extends Car {
	
	void siren() {
		System.out.println("물기");
	}
}