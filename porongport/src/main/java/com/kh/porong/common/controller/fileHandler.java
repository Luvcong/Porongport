package com.kh.porong.common.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface fileHandler {
	
	public default String saveFile(MultipartFile upfile, HttpSession session, String path) {
		
		String originName = upfile.getOriginalFilename();
		// System.out.println(originName);
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		
		// 임의의 난수(5자리 랜덤값)
		int ranNum = (int)(Math.random() * 90000 + 10000);
		
		// 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		// Path savePaths= Paths.get(session.getServletContext().getRealPath("/resources"), "uploadFiles", path, changeName);
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		
		try {
			upfile.transferTo(new File(savePath + path + changeName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "resources/uploadFiles/" + path + changeName;
	}
	
}	// end class