package com.aia.it.member.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Member {
	
	private int uidx;
	private String uid;
	private String upw;
	private String uname;
	private String uphonenum;
	private String uphoto;
	private String ucode;
	private char verify;
	private Date uregdate;
	

	
	public Member() {
	}

	public Member(int uidx, String uid, String upw, String uname, String uphonenum, String uphoto, String ucode,
			Date uregdate) {
		this.uidx = uidx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphonenum = uphonenum;
		this.uphoto = uphoto;
		this.ucode = ucode;
		this.uregdate = uregdate;
	
	}
	
	public Member(String uid, String upw, String uname, String uphonenum) {
		this(0, uid, upw, uname, uphonenum, null, null,null);
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
	
	public String getUphonenum() {
		return uphonenum;
	}

	public void setUphonenum(String uphonenum) {
		this.uphonenum = uphonenum;
	}

	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public String getUcode() {
		return ucode;
	}
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
	public char getVerify() {
		return verify;
	}
	public void setVerify(char verify) {
		this.verify = verify;
	}
	public Date getUregdate() {
		return uregdate;
	}
	public void setUregdate(Date uregdate) {
		this.uregdate = uregdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setUregdate1(Date uregdate) {
		this.uregdate = uregdate;
	}

	// java.sql.Date -> java.util.Date
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate() {// ${member.toDate}
		return new java.util.Date(uregdate.getTime());
	}

	// Member -> LoginInfo : 로그인 처리시 저장할 데이터
//	public LoginInfo toLoginInfo() {
//		return new LoginInfo(uid, uname, uphoto);
//	}

	
	@Override
	public String toString() {
		return "Member [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphonenum="
				+ uphonenum + ", uphoto=" + uphoto + ", ucode=" + ucode + ", verify=" + verify + ", uregdate="
				+ uregdate + "]";
	}
	

}
