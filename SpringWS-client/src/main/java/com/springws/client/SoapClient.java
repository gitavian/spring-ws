package com.springws.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.ws.clients.sayHello.SayHello;
import com.ws.clients.sayHello.SayHelloResponse;

@Service
public class SoapClient extends WebServiceGatewaySupport {

	public SayHelloResponse getSayHelloMessage(String message) {

		SayHello request = new SayHello();
		request.setMessage(message);

		final String MESSAGE_PATH = "http://127.0.0.1:8080/JAXWS-Spring/jaxws-spring/sayHello";

		System.out.println("Requesti message : " + message);

		SayHelloResponse response = (SayHelloResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request,
						new SoapActionCallback(MESSAGE_PATH));

		return response;
	}
}
