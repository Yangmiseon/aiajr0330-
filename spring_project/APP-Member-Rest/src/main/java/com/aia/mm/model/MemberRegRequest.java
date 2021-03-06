package com.aia.mm.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {
	
	private String uid;
	private String upw;
	private String uname;
	private String uphonenumber;
	private MultipartFile uphoto;
	
	
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphonenumber() {
		return uphonenumber;
	}
	public void setUphonenumber(String uphonenumber) {
		this.uphonenumber = uphonenumber;
	}
	public MultipartFile getUphoto() {
		return uphoto;
	}
	public void setUphoto(MultipartFile uphoto) {
		this.uphoto = uphoto;
	}
	
	
	//MemberRegRequest에서 멤버로 보내줄때
	public Member toMember() {
		
		return new Member(uid, upw,uname, uphonenumber);
	}
	
	
	@Override
	public String toString() {
		return "MemberRegRequest [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphonenumber=" + uphonenumber
				+ ", uphoto=" + uphoto + "]";
	}
	
	
	

}
