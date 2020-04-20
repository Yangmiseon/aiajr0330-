package card;

public class Card {



		static int width = 100;
		static int height = 250;
		
		String kind;
		int number;

		public Card(){
			
		}//디폴트 생성자

		
		Card(String type, int num){
			kind = type;
			number = num;
		}//초기화의 용도
}
