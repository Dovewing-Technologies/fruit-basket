package com.codeninja;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HomeController {
	
	@Value("${server.port}")
	String serverPort; 
	
	@Value("${myapp.testproperty}")
    String testProperty;
	
	@ApiIgnore
    @RequestMapping("/")
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Logger logger = LoggerFactory.getLogger(Application.class);
	       
        logger.info("----------------------------------------");
        logger.info("Hello, test property value: " + this.testProperty);
        
		try {
			logger.info( "Hello Docker World");
			logger.info("Host Info: " + InetAddress.getLocalHost().getHostName());
			logger.info("Server Prort: " + serverPort);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	response.sendRedirect(ServletUriComponentsBuilder.fromCurrentContextPath().path("/swagger-ui.html").build().toUriString());
    }

}
