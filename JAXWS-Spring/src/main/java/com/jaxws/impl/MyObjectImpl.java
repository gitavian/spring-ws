package com.jaxws.impl;

import org.springframework.stereotype.Component;

import com.jaxws.model.MyObject;

@Component
public class MyObjectImpl implements MyObject {

	@Override
	public String printMessage(String message) {
		return "Here is your message: "+message;
	}

}
