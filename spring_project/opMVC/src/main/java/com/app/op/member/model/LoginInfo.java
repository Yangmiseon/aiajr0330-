package com.app.op.member.model;

public class LoginInfo {
	private String uid;
	private String uname;
	private String uphoto;
	
	
	
	
	
	public LoginInfo() {
	}



	public LoginInfo(String uid, String uname, String uphoto) {
		this.uid = uid;
		this.uname = uname;
		this.uphoto = uphoto;
	}



	public String getUid() {
		return uid;
	}



	public String getUname() {
		return uname;
	}



	public String getUphoto() {
		return uphoto;
	}



	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", uname=" + uname + ", uphoto=" + uphoto + "]";
	}
	
	
	

}
