package com.app.op.member.model;

public class LoginRequest {

	private String uid;
	private String upw;
	private String remember;
	private String redirecUri;
	
	
	
	public String getRedirecUri() {
		return redirecUri;
	}
	public void setRedirecUri(String redirecUri) {
		this.redirecUri = redirecUri;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}
	
	
	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", upw=" + upw + ", remember=" + remember + ", redirecUri=" + redirecUri
				+ "]";
	}
	
	
	
	
}
