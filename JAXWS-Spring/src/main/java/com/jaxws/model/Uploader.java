package com.jaxws.model;

import javax.activation.DataHandler;

public class Uploader {
	private String Name;
	private String FileType;
	private DataHandler Dfile;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String fileType) {
		FileType = fileType;
	}
	public DataHandler getDfile() {
		return Dfile;
	}
	public void setDfile(DataHandler dfile) {
		Dfile = dfile;
	}
	
	
}
