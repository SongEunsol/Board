package com.nineone.board.entity.db;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DbReplyEntity {
	SimpleDateFormat formatReply = new SimpleDateFormat("yyyy-MM-dd");
	
	int bno;
	int rno;
	String rwriter;
	String rpassword;
	String rcontent;
	Date rregdate;

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRregdate() {
		return formatReply.format(rregdate);
	}
	public void setRregdate(Date rregdate) {
		this.rregdate = rregdate;
	}
	
}
