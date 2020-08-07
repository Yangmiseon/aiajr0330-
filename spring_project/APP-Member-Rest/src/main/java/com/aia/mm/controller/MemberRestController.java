package com.aia.mm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mm.model.Member;
import com.aia.mm.model.MemberEditRequest;
import com.aia.mm.model.MemberRegRequest;
import com.aia.mm.service.MemberDeleteService;
import com.aia.mm.service.MemberEditservice;
import com.aia.mm.service.MemberListService;
import com.aia.mm.service.MemberRegService;
import com.aia.mm.service.MemberViewService;

@RestController
@RequestMapping("/members")
public class MemberRestController {
	
	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberRegService regService;
	
	@Autowired
	private MemberEditservice editService;
	
	@Autowired
	private MemberViewService viewService;
	
	@Autowired
	private MemberDeleteService deleteService;
	
	//회원의 리스트 : json으로 응답
	@GetMapping //GET  |  /members >>겟으로 들어왔을때
	public List<Member> getMemberList(){
	  
	  return listService.getMemberList();
	  
	}
	 
	//가입의 결과는 됐다, 안됐다만 주면 되니까 인티저도 반환받아도됨 0또는1 에러코드는 -1
	@PostMapping  //POST  |  /members  >>포스트로 들어왔을때
	public int reg(MemberRegRequest regRequest,
			HttpServletRequest reques) {
		
		System.out.println("컨트롤러에 있는 regRequest:"+regRequest);
		return regService.regMember(regRequest,reques);
	}
	
	
	//회원 1명의 정보 보기
	
	  @GetMapping("/{uidx}") 
	  public Member getMember(
			  @PathVariable("uidx") int uidx
			  ) {
	  
		  
	  return viewService.getMember(uidx); 
	  
	  }
	 
	
	//회원 1명의 정보 수정. 수정이 됐다, 안됐다니까 마찬가지로 int
	@PutMapping("/{uidx}") // PUT   |   /members/{uidx}
	public int edit(
			@PathVariable("uidx") int uidx,
			MemberEditRequest editRequest,
			HttpServletRequest request) {
		
		editRequest.setUidx(uidx);
		return editService.editMember(editRequest, request);
	}
	
	
	//회원 정보 삭제
	@DeleteMapping("/{uidx}")
	public int delete(
			@PathVariable("uidx") int uidx) {
		
		
		return deleteService.deleteMember(uidx);
	}
}
