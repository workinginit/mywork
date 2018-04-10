package org.vermeg.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.vermeg.entities.JiraConnexion;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

@Service
public class ConnexionJiraService {
	
	public JiraRestClient getJiraRestClient(JiraConnexion jcnx) {
		JiraRestClient jiraRestClient = null;
		try {
			URI baseUri = new URI(jcnx.getUrl());
			JiraRestClientFactory restClientFactory = new AsynchronousJiraRestClientFactory();
			//  Basic Http Authentication to connect to Jira
			jiraRestClient = restClientFactory.createWithBasicHttpAuthentication(baseUri, jcnx.getName(), jcnx.getPassword());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return jiraRestClient;
	}
	

}
