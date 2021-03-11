package com.company.dto;

public class SDto {
    private int bsno;        
    private String bstitle;      
    private String bswriter;
    private String bspublisher;  
    private String bsdate;
    private int bspage; 
    private String bsisbn13;    
    private String bsimg;
    private int bsprice;    
    private String bscate1;     
    private String bscate2;    
    private String bscate3;     
    private String bscontent;
	public int getBsno() {
		return bsno;
	}
	public void setBsno(int bsno) {
		this.bsno = bsno;
	}
	public String getBstitle() {
		return bstitle;
	}
	public void setBstitle(String bstitle) {
		this.bstitle = bstitle;
	}
	public String getBswriter() {
		return bswriter;
	}
	public void setBswriter(String bswriter) {
		this.bswriter = bswriter;
	}
	public String getBspublisher() {
		return bspublisher;
	}
	public void setBspublisher(String bspublisher) {
		this.bspublisher = bspublisher;
	}
	public String getBsdate() {
		return bsdate;
	}
	public void setBsdate(String bsdate) {
		this.bsdate = bsdate;
	}
	public int getBspage() {
		return bspage;
	}
	public void setBspage(int bspage) {
		this.bspage = bspage;
	}
	public String getBsisbn13() {
		return bsisbn13;
	}
	public void setBsisbn13(String bsisbn13) {
		this.bsisbn13 = bsisbn13;
	}
	public String getBsimg() {
		return bsimg;
	}
	public void setBsimg(String bsimg) {
		this.bsimg = bsimg;
	}
	public int getBsprice() {
		return bsprice;
	}
	public void setBsprice(int bsprice) {
		this.bsprice = bsprice;
	}
	public String getBscate1() {
		return bscate1;
	}
	public void setBscate1(String bscate1) {
		this.bscate1 = bscate1;
	}
	public String getBscate2() {
		return bscate2;
	}
	public void setBscate2(String bscate2) {
		this.bscate2 = bscate2;
	}
	public String getBscate3() {
		return bscate3;
	}
	public void setBscate3(String bscate3) {
		this.bscate3 = bscate3;
	}
	public String getBscontent() {
		return bscontent;
	}
	public void setBscontent(String bscontent) {
		this.bscontent = bscontent;
	}
	@Override
	public String toString() {
		return "SDto [bsno=" + bsno + ", bstitle=" + bstitle + ", bswriter=" + bswriter + ", bspublisher=" + bspublisher
				+ ", bsdate=" + bsdate + ", bspage=" + bspage + ", bsisbn13=" + bsisbn13 + ", bsimg=" + bsimg
				+ ", bsprice=" + bsprice + ", bscate1=" + bscate1 + ", bscate2=" + bscate2 + ", bscate3=" + bscate3
				+ ", bscontent=" + bscontent + "]";
	}
	public SDto() {
		// TODO Auto-generated constructor stub
	}
	public SDto(int bsno, String bstitle, String bswriter, String bspublisher, String bsdate, int bspage,
			String bsisbn13, String bsimg, int bsprice, String bscate1, String bscate2, String bscate3,
			String bscontent) {
		super();
		this.bsno = bsno;
		this.bstitle = bstitle;
		this.bswriter = bswriter;
		this.bspublisher = bspublisher;
		this.bsdate = bsdate;
		this.bspage = bspage;
		this.bsisbn13 = bsisbn13;
		this.bsimg = bsimg;
		this.bsprice = bsprice;
		this.bscate1 = bscate1;
		this.bscate2 = bscate2;
		this.bscate3 = bscate3;
		this.bscontent = bscontent;
	}
	
    
}
