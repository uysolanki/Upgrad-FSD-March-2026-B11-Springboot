package com.upgrad.UpgradB11Springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Player {

	@Id
	private int pno;
	private String pname;
	private int mp,rs;
	
	public Player() {}
	public Player(int pno, String pname, int mp, int rs) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.mp = mp;
		this.rs = rs;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getRs() {
		return rs;
	}
	public void setRs(int rs) {
		this.rs = rs;
	}
	@Override
	public String toString() {
		return "Player [pno=" + pno + ", pname=" + pname + ", mp=" + mp + ", rs=" + rs + "]";
	}
	
	
	
}
