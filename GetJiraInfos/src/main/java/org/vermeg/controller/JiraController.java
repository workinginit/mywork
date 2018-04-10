package org.vermeg.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.entities.Jira;
import org.vermeg.entities.JiraConnexion;
import org.vermeg.services.JiraService;

@RestController
@CrossOrigin("*")
public class JiraController {
	
	@Autowired
	private JiraService jiraservice;
	
	@RequestMapping(value="/jiraissues", method=RequestMethod.GET)
	public List<Jira> getcommits() throws IOException {
		JiraConnexion cx = new JiraConnexion("https://hedigaied.atlassian.net", "keyrus.recrute@gmail.com", "Hedihunter12");
		return jiraservice.allofjira(cx);
	}

}
