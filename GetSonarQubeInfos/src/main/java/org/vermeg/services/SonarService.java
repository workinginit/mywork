package org.vermeg.services;

import java.util.ArrayList;
import java.util.List;

import org.sonarqube.ws.Issues;
import org.sonarqube.ws.client.WsClient;
import org.sonarqube.ws.client.issue.SearchWsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.entities.Sonar;
import org.vermeg.entities.SonarConnexion;

@Service
public class SonarService {

	@Autowired
	private ConnexionSonarService cx;
	
	public List<Sonar> getIssue(SonarConnexion sc,String projectName){
		
		WsClient wsClient= cx.getWsClient(sc);
        SearchWsRequest searchWsRequest = new SearchWsRequest();
        ArrayList<String> projectKeys = new ArrayList<>();
        projectKeys.add(projectName);
        searchWsRequest.setProjectKeys(projectKeys);
        
        Issues.SearchWsResponse response = wsClient.issues().search(searchWsRequest);

        List<Issues.Issue> issuesList = response.getIssuesList();
    	ArrayList<Sonar> listofissue = new ArrayList<Sonar>();

        for (Issues.Issue issue : issuesList) {

        	Sonar s = new Sonar(issue.getProject(), issue.getType().toString(), issue.getSeverity().toString(), issue.getStatus(), issue.getDebt(),
        			issue.getCreationDate(), issue.getUpdateDate());
        	listofissue.add(s);
        }	

		return listofissue;
		
	}
}
