package org.vermeg.entities;

public class Jenkins {
	
	private int number;
	private String name;
	private long duration;
	private String result;
	private String date;
	
	public Jenkins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jenkins(int number, String name, long duration, String result, String date) {
		super();
		this.number = number;
		this.name = name;
		this.duration = duration;
		this.result = result;
		this.date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

  
}
