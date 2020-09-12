package com.myspring.pro27.blob;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import oracle.sql.BLOB;

@Component
public class imgBlobVO {
	
	private MultipartFile imgFile;

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}




}
