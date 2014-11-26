package com.jaxws.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import org.springframework.beans.factory.annotation.Autowired;

import com.jaxws.model.MyObject;
import com.jaxws.model.Uploader;

@MTOM
@WebService(endpointInterface = "com.jaxws.impl.SpringWs", serviceName = "SpringWs")
public class SpringWsImpl implements SpringWs {

	@Autowired
	MyObject myObject;

	@WebMethod(operationName = "sayHello")
	public void sayHello(String message) {
		System.out.println(myObject.printMessage(message));

	}

	@WebMethod(operationName="fileUploader")
	public void uploadFile(Uploader Dfile) {

		System.out.println("Within Method");
		DataHandler handler = Dfile.getDfile();
		try {
			final InputStream is = handler.getInputStream();

			OutputStream os = new FileOutputStream(new File("/Users/octavian/uploads/"
					+ Dfile.getName() + "." + Dfile.getFileType()));
			
			
			byte[] b = new byte[100000];
			int bytesRead = 0;
			while ((bytesRead = is.read(b)) != -1) {
				os.write(b, 0, bytesRead);
			}
			
			os.flush();
			os.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
