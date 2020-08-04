package com.app.op.member.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	
	private int uidx;
	private String uid;
	private String upw;
	private String uname;
	private String uphonenumber;
	private String uphoto;
	private Date uregdate;
	
	
	
	public Member(int uidx, String uid, String upw, String uname, String uphonenumber, String uphoto, Date uregdate) {
		this.uidx = uidx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphonenumber = uphonenumber;
		this.uphoto = uphoto;
		this.uregdate = uregdate;
	}
	
	
	//MemberRegRequest에서 멤버로 보내줄때 받는거
	public Member(String uid, String upw, String uname,String uphonenumber) {
		this(0, uid, upw, uname, uphonenumber, null, null);
	}


	public Member() {
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
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public Date getUregdate() {
		return uregdate;
	}
	public void setUregdate(Date uregdate) {
		this.uregdate = uregdate;
	}
	
	
	//java.sql.Date >> java.util.Date로 바꿔주는메서드
	public java.util.Date getToDate(){//부를때>>${member.toDate}
			
		return new java.util.Date(uregdate.getTime());
	}


	@Override
	public String toString() {
		return "Member [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphonenumber="
				+ uphonenumber + ", uphoto=" + uphoto + ", uregdate=" + uregdate + "]";
	}
	
	


}
