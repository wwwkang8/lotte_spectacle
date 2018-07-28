package org.lotte.dotcom.vo;

public class MemberVO {
	private String memberId;
	private String password;
	private String name;
	private String phoneNumber;
	private String sms;
	public MemberVO(String memberId, String password, String name, String phoneNumber, String sms) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.sms = sms;
	}
	public MemberVO() {
		super();
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", password=" + password + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", sms=" + sms + "]";
	}

	
	
}
