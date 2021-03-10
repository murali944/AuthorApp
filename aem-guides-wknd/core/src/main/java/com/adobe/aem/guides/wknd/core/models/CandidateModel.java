package com.adobe.aem.guides.wknd.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class CandidateModel {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	@Optional
	private String candidate;

	@Inject
	@Optional
	private String rollno;

	@PostConstruct
	protected void init() {
		logger.debug("Inside init of State model");
		logger.debug("Printing candidate and candidate -->{},{}",candidate,candidate);
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	
	

}
