package com.aia.mm.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.mm.dao.MemberDao;
import com.aia.mm.model.Member;
import com.aia.mm.model.MemberRegRequest;

@Service
public class MemberRegService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int regMember(
			MemberRegRequest regRequest,
			HttpServletRequest request) {
		
		Member member = regRequest.toMember();
		dao=sessionTemplate.getMapper(MemberDao.class);
		  int result = 0;

		
		  //파일업로드 처리
	try {
		MultipartFile file = regRequest.getUphoto();
		  
		  System.out.println(regRequest);
		  
		  //사진이 있다면 사진 파일을 물리적으로 저장, 없다면 기본 이미지 파일의 경로를 저장
		  if(file != null && !file.isEmpty() && file.getSize()>0) {
		  
		  //서버 내부의 경로 
			  String uri = "/upload";
		  
		  
		  //시스템의 실제(절대)경로 
			 
		String realPath = request.getSession().getServletContext().getRealPath(uri); 
		  //저장할 이미지 파일의 새로운 이름 생성 
		  String newFileName = System.nanoTime()+"_"+file.getOriginalFilename();
		  
		  //서버의 저장소에 실제 저장 
		  File saveFile = new File(realPath, newFileName);
		 
			file.transferTo(saveFile);
		
		  
		  System.out.println("저장완료: "+newFileName);
		  
		  //데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진경로 
		  
		  member.setUphoto(newFileName);
		  
		  
		  }else { 
			  member.setUphoto("default.png"); 
			  
		  		}
		  
		  result = dao.insertMember(member);
		  
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} 
		
		return result;
	}

}
