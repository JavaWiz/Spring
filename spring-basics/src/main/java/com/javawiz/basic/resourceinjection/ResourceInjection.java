package com.javawiz.basic.resourceinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceInjection {

	@Autowired
	private ResourceLoader resourceLoader;

	private Resource textFile;

	public void setTextFile(Resource textFile) {
		this.textFile = textFile;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public Resource getTextFile() {
		return textFile;
	}
	
	public Resource loadDynamicResource(){
		//in case when resource will be loaded based on some condition
		boolean someCondition=true;
		if(someCondition){
			return resourceLoader.getResource("resourceinjection/sample2.txt");
		}else{
			return resourceLoader.getResource("resourceinjection/sample.txt");
		}
	}
}
