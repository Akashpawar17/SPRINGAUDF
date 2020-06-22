package com.capgemini.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avatar {
	@Id
	
	
	
	private int aid;
	private String aname;
	private String tech;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Avatar [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
	}
	

}
