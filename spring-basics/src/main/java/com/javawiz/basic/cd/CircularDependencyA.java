package com.javawiz.basic.cd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {
	
	private CircularDependencyB circularDependencyB;

	public void setCircularDependencyB(CircularDependencyB circularDependencyB) {
		this.circularDependencyB = circularDependencyB;
	}
	
	@Autowired
	public CircularDependencyA(CircularDependencyB circularDependencyB) {
		this.circularDependencyB = circularDependencyB;
	}
}
