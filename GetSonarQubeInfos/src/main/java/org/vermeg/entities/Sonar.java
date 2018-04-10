package org.vermeg.entities;

public class Sonar {
	
	private String projectName;
	private String type;
	private String severity;
	private String status;
	private String debt;
	private String creationDate;
	private String updateDate;
	
	public Sonar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sonar(String projectName, String type, String severity, String status, String debt, String creationDate,
			String updateDate) {
		super();
		this.projectName = projectName;
		this.type = type;
		this.severity = severity;
		this.status = status;
		this.debt = debt;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDebt() {
		return debt;
	}
	public void setDebt(String debt) {
		this.debt = debt;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


}
