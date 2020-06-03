package a1;

public class PhoneInfo {
	
	private int idx;
	private String fr_Name;
	private String fr_phonenumber;
	private String fr_email;
	private String fr_address;

	public PhoneInfo(int idx,String fr_Name,String fr_phonenumber,
					String fr_email,String fr_address) {
		this.idx=idx;
		this.fr_Name=fr_Name;
		this.fr_phonenumber=fr_phonenumber;
		this.fr_email=fr_email;
		this.fr_address=fr_address;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getFr_Name() {
		return fr_Name;
	}

	public void setFr_Name(String fr_Name) {
		this.fr_Name = fr_Name;
	}

	public String getFr_phonenumber() {
		return fr_phonenumber;
	}

	public void setFr_phonenumber(String fr_phonenumber) {
		this.fr_phonenumber = fr_phonenumber;
	}

	public String getFr_email() {
		return fr_email;
	}

	public void setFr_email(String fr_email) {
		this.fr_email = fr_email;
	}

	public String getFr_address() {
		return fr_address;
	}

	public void setFr_address(String fr_address) {
		this.fr_address = fr_address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PhoneInfo[idx= "+idx+", fr_Name= "+fr_Name+", fr_phonenumber"+fr_phonenumber+
				", fr_email= "+fr_email+", fr_address = "+fr_address+"]";
	}
	
	
}
