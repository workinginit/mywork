package org.vermeg.entities;

public class JiraConnexion {
	
	private String url;
    private String name;
    private String password;
    
	public JiraConnexion() {
		super();
	}
	public JiraConnexion(String url, String name, String password) {
		super();
		this.url = url;
		this.name = name;
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "JiraConnexion [url=" + url + ", name=" + name + ", password=" + password + "]";
	}
}
