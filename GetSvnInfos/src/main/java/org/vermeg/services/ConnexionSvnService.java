package org.vermeg.services;

import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import org.vermeg.entities.SvnRepositoryConnexion;

@Service
public class ConnexionSvnService {

	@SuppressWarnings("deprecation")
	public SVNRepository connexionRepository(SvnRepositoryConnexion repo) throws SVNException {
		//Set up connection protocols
		DAVRepositoryFactory.setup();

		SVNRepository repository = null;
		
		repository = SVNRepositoryFactory.create( SVNURL.parseURIEncoded( repo.getUrl()) );
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager( repo.getName(), repo.getPassword() );
        repository.setAuthenticationManager( authManager );
        
        return repository;
	}
	
}