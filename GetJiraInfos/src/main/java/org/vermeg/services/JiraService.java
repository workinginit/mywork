package org.vermeg.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.entities.Jira;
import org.vermeg.entities.JiraConnexion;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.util.concurrent.Promise;

@Service
public class JiraService {
	
	@Autowired
	private UpdateKeyService urs;
	
	@Autowired
	private ConnexionJiraService cjs;
	 
	private ArrayList<Jira> listOfIssues;
	private int j;
	private String last;
	
	public List<Jira> allofjira(JiraConnexion jcnx) throws IOException{
		
		listOfIssues = new ArrayList<>();
		j = 0;

		JiraRestClient jrc = cjs.getJiraRestClient(jcnx);
		getallIssues(jrc, urs.getLastRevision());
		jrc.close();
		
		return listOfIssues;
	}
	
	public List<Jira> getallIssues(JiraRestClient jcnx, int i) throws IOException{

 		Promise<SearchResult> sr = jcnx.getSearchClient().searchJql("project = testingvermega ORDER BY KEY ASC", 10, i, null); 

 	 	for (Issue issue : sr.claim().getIssues()) {
 	 	 		Jira jira = new Jira(issue.getId(), issue.getProject().getName(), issue.getKey(), issue.getSummary(), issue.getIssueType().getName(),issue.getStatus().getName(), issue.getPriority().getName(), 
 	 	 					(issue.getResolution() == null ? "NoResolution" : issue.getResolution().getDescription()), 
 	 	 					(issue.getAssignee() == null ? "NotAssigned" : issue.getAssignee().getDisplayName()), 
 	 	 					(issue.getReporter() == null ? "NoReporter" : issue.getReporter().getDisplayName()), 
 	 	 					DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(issue.getCreationDate()), 
 	 	 					DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(issue.getUpdateDate()), issue.getDescription());
 	 	 		listOfIssues.add(jira); 		
 	 	 		j++; 	
 	 	 		last = issue.getKey().substring(issue.getKey().indexOf("-")+1);
 	 	 		if((j % 10) == 0) {
 	 	 			getallIssues(jcnx, j);
 	 	 		}
 	      }
 	 	
 	 	if(j!=0) {
 	 		urs.setLastRevision(last);
 	 	}
		
		return listOfIssues;		
	}
	


}
