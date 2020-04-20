package test;

public class Triangle2 {

		// 변수 :  밑변, 높이
		
		int width; //밑변의 데이터-멤버변수
		int height; // 높이 데이터-멤버변수
		
		
		
		//생성자 생성>> 보통 변수 밑에 생성
		//인스턴스 생성시에 반드시 한번 실행한다. 
		//       >>인스턴스 변수들의 초기화 작업에 목적을 둔다.
		//		  >>생락 가능(default Contrutor)
		
		//기본 생성자 
		Triangle2(){
			
		}
		Triangle2(int w, int h) {//셋데이터와 같은역할
			width = w;
			height = h;
		}
		
		
		
		//밑변과 높이 데이터를 변경하는 메서드
		void setData(int w, int h) {//반환타입이 없으니 보이드. 여기인트변수는 지역변수
			width = w; //멤버변수여서 호출가능.
			height=h;
			
		}//위드 하이 값 받는 순간 w,h는 소멸. 위드와 하이는 소멸안함
	
		//삼각형의 넓이를 구해서 반환하는 메서드. 
		float area() {
			float result = width*height/2f;
			return result;
		}
		
		public static void main(String[] args) {
			//여기서는 하이 사용 못함. 인스턴스 사용하기 위해 인스턴스변수 생성
			//삼각형 객체 새성
			Triangle2 t = new Triangle2(5,3);
			
			
			//데이터설정
			t.setData(5, 3);
			System.out.println("삼각형의 밑변: "+ t.width+" 삼각형의 높이는: "+t.height);
					
			//넓이를 구하는 메서드 실행
			System.out.println("삼각형의 넓이는 "+t.area()+"입니다.");
		}
		
}
