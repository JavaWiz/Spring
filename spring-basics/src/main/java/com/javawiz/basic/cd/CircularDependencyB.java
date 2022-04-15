package com.javawiz.basic.cd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {
	
	private CircularDependencyA circularDependencyA;
	
	@Autowired
	public void setCircularDependencyA(CircularDependencyA circularDependencyA) {
		this.circularDependencyA = circularDependencyA;
	}

	@Autowired
	public CircularDependencyB(@Lazy CircularDependencyA circularDependencyA) {
		this.circularDependencyA = circularDependencyA;
	}
}
