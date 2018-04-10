package org.vermeg.entities;

public class Svn {
	
	private String author;
	private int revision;
	private String date;
	private String path;
	private String type;
	private String kind;
	
	public Svn() {
		super();
	}
	public Svn(String author, int revision, String date, String path, String type, String kind) {
		super();
		this.author = author;
		this.revision = revision;
		this.date = date;
		this.path = path;
		this.type = type;
		this.kind = kind;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
		this.revision = revision;
	}
	public String getDate() {
		return date;
	}
	public String setDate(String date) {
		return this.date = date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}
