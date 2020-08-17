package com.aia.it.member.model;

public class LoginInfo {
	
	private int uidx;
	private String uid;
	private String uname; 
	private String uphoto;
	
	public LoginInfo() {
	}
	
	
	public LoginInfo(int uidx, String uid, String uname, String uphoto) {
		this.uidx = uidx;
		this.uid = uid;
		this.uname = uname;
		this.uphoto = uphoto;
	}
	
	
	public int getUidx() {
		return uidx;
	}


	public void setUidx(int uidx) {
		this.uidx = uidx;
	}


	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}


	@Override
	public String toString() {
		return "LoginInfo [uidx=" + uidx + ", uid=" + uid + ", uname=" + uname + ", uphoto=" + uphoto + "]";
	}
	
	
	
	
	
	

}
