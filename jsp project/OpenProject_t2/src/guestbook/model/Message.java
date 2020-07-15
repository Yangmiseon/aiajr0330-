package guestbook.model;
//빈즈의 목적은 데이터의 저장목적.
//각각의 클래스들간에 주고 받을때 사용하려는 객체
public class Message {

	//메세지 객체를 받을때도 쓸건데 디비에서 가져올때도 담을 곳이 필요함.
	private int idx; 
	private String uname;
	private String pw;
	private String message;
	
	
	public Message(int idx, String uname, String pw, String message) {
		this.idx = idx;
		this.uname = uname;
		this.pw = pw;
		this.message = message;
	}


	public Message() {
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "Message [idx=" + idx + ", uname=" + uname + ", pw=" + pw + ", message=" + message + "]";
	}
	
	
	
}
