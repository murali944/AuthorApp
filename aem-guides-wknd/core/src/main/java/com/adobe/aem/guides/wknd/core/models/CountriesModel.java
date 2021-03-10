package com.adobe.aem.guides.wknd.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class CountriesModel {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * @Inject
	 * 
	 * @Named("sling:resourceType")
	 * 
	 * @Default(values = "No resourceType") protected String resourceType;
	 */
	
	@ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String resourceType;

	//@Inject
	@ValueMapValue
	@Optional
	private List<Resource> countries;

	private List<CountryModel> countriesList = new ArrayList<>();

	public List<CountryModel> getCountriesList() {
		return countriesList;
	}

	public void setCountriesList(List<CountryModel> countriesList) {
		this.countriesList = countriesList;
	}

	@PostConstruct
	protected void init() {
		logger.debug("In init of CountriesModel");
		//if (!countries.isEmpty()) {
			for (Resource resource : countries) {
				CountryModel student = resource.adaptTo(CountryModel.class);
				countriesList.add(student);
			}
		//}
	}

}