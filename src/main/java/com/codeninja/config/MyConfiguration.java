package com.codeninja.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Niranjan
 */
@ConfigurationProperties("cloudsql")
public class MyConfiguration {

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String url;
	
	private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
