package org.vermeg.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class UpdateKeyService {
	
	public int getLastRevision() {
		final Properties prop = new Properties();
		InputStream input = null;
		int i = 0;

		try {
				input = new FileInputStream("store.properties");
				
				// load a properties file
				prop.load(input);
	
				// get the property value and print it out
				i = Integer.parseInt(prop.getProperty("last-issue"));  
		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return i;
	}
	
	
	public void setLastRevision(String j) {
		final Properties prop = new Properties();
		OutputStream output = null;

		try {

				output = new FileOutputStream("store.properties");
	
				// set the properties value
				prop.setProperty("last-issue", j);
	
				// save properties to project root folder
				prop.store(output, null);

		} catch (final IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
