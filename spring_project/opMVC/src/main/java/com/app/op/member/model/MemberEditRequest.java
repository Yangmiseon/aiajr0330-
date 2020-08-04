package com.app.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberEditRequest {
	
	private int uidx;
	private String uid;
	private String upw;
	private String uname;
	private String uphonenumber;
	private MultipartFile photo;
	private String oldFile;
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
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getOldFile() {
		return oldFile;
	}
	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}
	
	
	public Member toMember() {
		return new Member(uidx, uid, upw, uname, uphonenumber, oldFile.length()>0?oldFile:null, null);
	}

	
	
	@Override
	public String toString() {
		return "MemberEditRequest [uidx=" + uidx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname
				+ ", uphonenumber=" + uphonenumber + ", photo=" + photo + ", oldFile=" + oldFile + "]";
	}
	

}
