package org.vermeg.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.vermeg.entities.JenkinsServerConnexion;

import com.offbytwo.jenkins.JenkinsServer;

@Service
public class ConnexionJenkinsService {
	
	public JenkinsServer connexionJenkinsServer(JenkinsServerConnexion jsc) throws URISyntaxException {
		
		JenkinsServer jenkins = new JenkinsServer(new URI(jsc.getUrl()), jsc.getName(), jsc.getPassword());	
		return jenkins;
		
	}

}
