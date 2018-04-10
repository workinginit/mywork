package org.vermeg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vermeg.entities.Sonar;
import org.vermeg.entities.SonarConnexion;
import org.vermeg.services.SonarService;

@RestController
@CrossOrigin("*")
public class SonarController {
	@Autowired
	private SonarService sonarserv;
	
	@RequestMapping(value="/allissue", method=RequestMethod.GET)
	public List<Sonar> getIssue(){
		SonarConnexion sc = new SonarConnexion("http://localhost:7223", "admin", "admin", "a0f08c8a2e9c1fa424d3da007315268e5b5a1031");
		
		return sonarserv.getIssue(sc, "moustachetest");
		
	}
	
}
