package org.vermeg.entities;

public class JenkinsServerConnexion {
	
	private String url;
    private String name;
    private String password;
    
	public JenkinsServerConnexion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JenkinsServerConnexion(String url, String name, String password) {
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
    
}
