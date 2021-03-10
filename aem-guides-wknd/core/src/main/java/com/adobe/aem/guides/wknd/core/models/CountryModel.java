package com.adobe.aem.guides.wknd.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Country.
 */
@Model(adaptables = Resource.class)
public class CountryModel {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	@Optional
	private String countryName;

	
	@Inject
	@Optional
	private List<Resource> states;

	@Optional
	private List<StateModel> stateList = new ArrayList<>();

	public List<StateModel> getStateList() {
		return stateList;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/*
	 * public String getStateName() { return stateName; }
	 * 
	 * public void setStateName(String stateName) { this.stateName = stateName; }
	 */

	public void setStateList(List<StateModel> stateList) {
		this.stateList = stateList;
	}

	@PostConstruct
	protected void init() {
		logger.debug("In init method of Country model.");
		if (!states.isEmpty()) {
			for (Resource resource : states) {
				StateModel state = resource.adaptTo(StateModel.class);
				stateList.add(state);
			}
		}
	}

}