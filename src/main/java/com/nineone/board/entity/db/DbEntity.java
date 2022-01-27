package com.nineone.board.entity.db;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DbEntity {
	SimpleDateFormat formatBoard = new SimpleDateFormat("MM월 dd일 E요일 (a hh:mm)");
	
	int bno;
	String bwriter;
	String bpassword;
	String btitle;
	String bcontent;
	Date bregdate;

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBpassword() {
		return bpassword;
	}
	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBregdate() {
		return formatBoard.format(bregdate);
	}
	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}
//	
//	int rno;
//	String rwriter;
//	String rpassword;
//	String rcontent;
//	Date rregdate;
//	
//	public int getRno() {
//		return rno;
//	}
//	public void setRno(int rno) {
//		this.rno = rno;
//	}
//	public String getRwriter() {
//		return rwriter;
//	}
//	public void setRwriter(String rwriter) {
//		this.rwriter = rwriter;
//	}
//	public String getRpassword() {
//		return rpassword;
//	}
//	public void setRpassword(String rpassword) {
//		this.rpassword = rpassword;
//	}
//	public String getRcontent() {
//		return rcontent;
//	}
//	public void setRcontent(String rcontent) {
//		this.rcontent = rcontent;
//	}
//	public String getRregdate() {
//		return formatReply.format(rregdate);
//	}
//	public void setRregdate(Date rregdate) {
//		this.rregdate = rregdate;
//	}
	
}
