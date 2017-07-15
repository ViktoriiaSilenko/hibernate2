package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;

public class Hit extends BaseEntity{
	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public LocalDateTime getViewed() {
		return viewed;
	}

	public void setViewed(LocalDateTime viewed) {
		this.viewed = viewed;
	}	

}
