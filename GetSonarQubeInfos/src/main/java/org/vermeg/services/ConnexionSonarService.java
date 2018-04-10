package org.vermeg.services;

import org.sonarqube.ws.client.HttpConnector;
import org.sonarqube.ws.client.WsClient;
import org.sonarqube.ws.client.WsClientFactories;
import org.springframework.stereotype.Service;
import org.vermeg.entities.SonarConnexion;


@Service
public class ConnexionSonarService {

	public WsClient getWsClient(SonarConnexion sc) {
		
		 HttpConnector httpConnector = HttpConnector.newBuilder().url(sc.getUrl()).credentials(sc.getName(), sc.getPassword()).token(sc.getToken()).build();
	     WsClient wsClient = WsClientFactories.getDefault().newClient(httpConnector);
	     
		return wsClient;
		
	}

}
