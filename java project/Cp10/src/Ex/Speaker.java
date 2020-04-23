package Ex;

public class Speaker {
	
	//스피커는 켜지 않은상태니까 초기화 0 
	private int volumeRate;
	
	//현재 상태 출력
	public void showCurrentState(){
	
		System.out.println("볼륨 크기: "+ this.volumeRate);
	}
	
	
	public void setVolume(int vol){
	
		this.volumeRate=vol;
	}

}
