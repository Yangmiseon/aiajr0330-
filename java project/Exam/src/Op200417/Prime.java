package Op200417;

public class Prime {

	public static void main(String[] args) {
		
		boolean a = true;
		int count=0;
		
			for(int i=2; i<=10; i++) {
				for(int j = 2; j<=i; j++) {
					if(i%j==0) {
						count++;
					}
						
						
					}if(count>2) {
						a=true;
						}else if(count==1){
						a=false;	
						}System.out.println(i+": "+a);
				}
			}
		
		
		
		
	}