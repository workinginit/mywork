package org.vermeg.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.entities.Jenkins;
import org.vermeg.entities.JenkinsServerConnexion;
import org.vermeg.services.JenkinsService;

@RestController
@CrossOrigin("*")
public class JenkinsController {
	
	@Autowired
	private JenkinsService js;
	
	@RequestMapping(value="/allbuilds", method=RequestMethod.GET)
	public List<Jenkins> getbuilds() throws URISyntaxException, IOException{
		
		JenkinsServerConnexion jsc = new JenkinsServerConnexion("http://localhost:8080", "hedi","Hedihunter12");
		
		return js.allJenkinsBuild(jsc, "moustachetest");
	
	}
	
	
}
