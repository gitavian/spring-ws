package com.jaxws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.jaxws.model.Uploader;

@WebService
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public interface SpringWs {
	@WebMethod public String sayHello(@WebParam(name="message") String message);
	@WebMethod public void uploadFile(@WebParam(name="file") Uploader uploader);
}
