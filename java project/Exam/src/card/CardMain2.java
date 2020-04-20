package card;

public class CardMain2 {
	public static void main(String[] args) {
				
		String grade = " ";
		for(int i=1; i<5; i++) {
			if(i==1)
				grade = "하트";
			else if(i==2)
				grade = "스페이드";
			else if(i==3)
				grade = "클로버";
			else
				grade = "다이아몬드";
			for(int j=1; j<14; j++) {
				
				Card c = new Card();
				c.kind=grade;
				c.number = j;
				System.out.println("첫번째 카드는" +c.kind+" "+c.number+"카드의 높이는" +c.height+"이고 폭은"+c.width+"이다");

			}
			
		
		}
		
		for(int i=1; i<5; i++) {
			
			for(int j=1; j<14; j++) {
				String kind = " ";
			
			switch(i) {
			case 1:
				kind = "Spade";
				break;
			case 2:
				kind = "Clover";
				break;
			case 3:
				kind = "Heart";
				break;
			case 4:
				kind = "Diamond";
				break;
			}
				
				Card c = new Card();
				c.kind=kind;
				c.number = j;
				System.out.println("첫번째 카드는" +c.kind+" "+c.number+"카드의 높이는" +c.height+"이고 폭은"+c.width+"이다");

			}
		
		
		
		
		
	}
}
}
