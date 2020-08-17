package com.aia.it.member.model;

public class LoginRequest {
	
	private int uidx;
	private String uid;
	private String upw;
	private String remember;
	private String redirectUri;

	
	
	public int getUidx() {
		return uidx;
	}
	public void setUidx(int uidx) {
		this.uidx = uidx;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
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
		return "LoginRequest [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", remember=" + remember
				+ ", redirectUri=" + redirectUri + "]";
	}
	
	
	
	
	
}
