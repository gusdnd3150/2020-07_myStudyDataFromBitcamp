package com.myspring.pro27.blob;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class imgBlobController {
	
	@Autowired
	private ImgBlobDao dao;
	
	@RequestMapping(value = "/formFile")
	public String formFile() {
		return "imgblob/formFile";
	}
	
	@RequestMapping(value="/saveImage")
	public String saveImage(imgBlobVO vo) {
		try {
			Map<String,Object> hmap = new HashMap<String,Object>();
			hmap.put("img", vo.getImgFile().getBytes());
			dao.saveImage(hmap);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
		return "redirect:view";
	}
	
    @RequestMapping(value = "/view")
    public String view() {
        return "imgblob/view";
    }
	
    @RequestMapping(value ="/getByteImage")
	public ResponseEntity<byte[]> getByteImage(){
		Map<String,Object> map = dao.getByteImage();
		byte[] imageContent = (byte[])map.get("img");
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent,headers,HttpStatus.OK);
	}
	
	
	

}
