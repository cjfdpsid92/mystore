package com.company.dto;

public class MDto {
	private int mno;
	private String mid;
	private String mname;
	private String mpass;
	private String memail;
	private String mdate;
	private String mip;
	private String mail_yes;
	private String sns;
	private String sms;
	private String usersex;
	private int postcode;
	private String address1;
	private String address2;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getMip() {
		return mip;
	}
	public void setMip(String mip) {
		this.mip = mip;
	}
	public String getMail_yes() {
		return mail_yes;
	}
	public void setMail_yes(String mail_yes) {
		this.mail_yes = mail_yes;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Override
	public String toString() {
		return "MDto [mno=" + mno + ", mid=" + mid + ", mname=" + mname + ", mpass=" + mpass + ", memail=" + memail
				+ ", mdate=" + mdate + ", mip=" + mip + ", mail_yes=" + mail_yes + ", sns=" + sns + ", sms=" + sms
				+ ", usersex=" + usersex + ", postcode=" + postcode + ", address1=" + address1 + ", address2="
				+ address2 + "]";
	}
	public MDto(int mno, String mid, String mname, String mpass, String memail, String mdate, String mip,
			String mail_yes, String sns, String sms, String usersex, int postcode, String address1, String address2) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mname = mname;
		this.mpass = mpass;
		this.memail = memail;
		this.mdate = mdate;
		this.mip = mip;
		this.mail_yes = mail_yes;
		this.sns = sns;
		this.sms = sms;
		this.usersex = usersex;
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
	}
	public MDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
