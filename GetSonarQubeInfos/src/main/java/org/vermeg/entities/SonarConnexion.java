package org.vermeg.entities;

public class SonarConnexion {
	
	private String url;
    private String name;
    private String password;
    private String token;
	public SonarConnexion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SonarConnexion(String url, String name, String password, String token) {
		super();
		this.url = url;
		this.name = name;
		this.password = password;
		this.token = token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
}
