package org.vermeg.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.vermeg.entities.Svn;
import org.vermeg.entities.SvnRepositoryConnexion;

@Service
public class SvnService {
			
	@Autowired
	private UpdateRevisionService urs;
	
	@Autowired
	private ConnexionSvnService cnx;

	public List<Svn> getcommit(SvnRepositoryConnexion repo, String[] array, long startRevision, long endRevision) throws SVNException{
		
    	ArrayList<Svn> listofcommit = new ArrayList<Svn>();
        String test = null;

		SVNRepository repository =  cnx.connexionRepository(repo) ;
        Collection<?> logEntries = null;
        logEntries = repository.log(array , null , startRevision , endRevision , true , true );
        
        for ( Iterator<?> entries = logEntries.iterator( ); entries.hasNext( ); ) {
            SVNLogEntry logEntry = ( SVNLogEntry ) entries.next( );

            if((int) logEntry.getRevision( ) > urs.getLastRevision()) {
            	
		            if ( logEntry.getChangedPaths( ).size( ) > 0 ) {
		          
		                Set<?> changedPathsSet = logEntry.getChangedPaths( ).keySet( );
		
		                for ( Iterator<?> changedPaths = changedPathsSet.iterator( ); changedPaths.hasNext( ); ) {
		                    SVNLogEntryPath entryPath = ( SVNLogEntryPath ) logEntry.getChangedPaths( ).get( changedPaths.next( ) );
		
		                    Svn s = new Svn(logEntry.getAuthor(), (int) logEntry.getRevision(), DateFormatUtils.format(logEntry.getDate(), "yyyy-MM-dd HH:mm:SS"),
		                    		entryPath.getPath(), String.valueOf(entryPath.getType()), entryPath.getKind().toString());
		                    listofcommit.add(s);			                   
		                }
		            }
            }
     
            test = String.valueOf(logEntry.getRevision());      
        }
        
        if(!listofcommit.isEmpty()) {
            urs.setLastRevision(test);
        }
		repository.closeSession();     
		return listofcommit;
	}

}
