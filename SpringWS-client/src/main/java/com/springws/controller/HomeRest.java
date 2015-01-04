package com.springws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springws.client.SoapClient;

@Controller
@RestController
public class HomeRest {

	@Autowired
	SoapClient soapClient;
	
	@RequestMapping(value = "/practiceMessage", method = RequestMethod.POST)
	public String practiceMessage(@RequestParam("message") String message) {
		
		System.out.println("inside practiceMessage");
		String clientMessageResponse = soapClient.getSayHelloMessage(message).toString();
		
		System.out.println(clientMessageResponse);

		return clientMessageResponse;
	}

}
