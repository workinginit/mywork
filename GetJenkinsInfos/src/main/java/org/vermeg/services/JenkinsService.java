package org.vermeg.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vermeg.entities.Jenkins;
import org.vermeg.entities.JenkinsServerConnexion;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

@Service
public class JenkinsService {
	
	@Autowired
	private ConnexionJenkinsService cjs;

	public List<Jenkins> allJenkinsBuild(JenkinsServerConnexion jsc, String ProjectName) throws URISyntaxException, IOException{
		JenkinsServer jenkins = cjs.connexionJenkinsServer(jsc);
		ArrayList<Jenkins> listofbuild = new ArrayList<Jenkins>();
		Map<String, Job> jobs = jenkins.getJobs();

		JobWithDetails job = jobs.get(ProjectName).details();
		
		for(Build build:job.getAllBuilds()) {

			   Jenkins jk = new Jenkins(build.getNumber(), build.details().getFullDisplayName(),  build.details().getDuration(),
					   build.details().getResult().toString(), DateFormatUtils.format(build.details().getTimestamp(), "yyyy-MM-dd HH:mm:SS"));
			   listofbuild.add(jk);
		 }
		
		return listofbuild;	
	}
	
}
