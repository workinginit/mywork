package org.vermeg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tmatesoft.svn.core.SVNException;
import org.vermeg.entities.Svn;
import org.vermeg.entities.SvnRepositoryConnexion;
import org.vermeg.services.SvnService;

@RestController
@CrossOrigin("*")
public class SvnController {
	
	@Autowired
	private SvnService svnservice;

	@RequestMapping(value="/allcommit", method=RequestMethod.GET)
	public List<Svn> getcommits() throws SVNException{
        long startRevision = 0;
        long endRevision = -1; //HEAD (the latest) revision
        String[] array =  new String[] { "" };//path
		
        SvnRepositoryConnexion repo = new SvnRepositoryConnexion("https://svn.riouxsvn.com/testvermegone", "hedihunter" , "Hedihunter12");
      
		return svnservice.getcommit(repo, array, startRevision, endRevision);
	}
		
}
