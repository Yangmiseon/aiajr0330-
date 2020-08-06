package com.aia.rest1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rest1.model.Member;

@RestController
@RequestMapping("/rest/v1")
public class RestTestController {

	
	
	@RequestMapping("/memberlist")
	public List<Member> getList(){
		
		List<Member> list= new ArrayList<Member>();
		list.add(new Member (1,"aa1","@ga","rew",new Date()));
		list.add(new Member (2,"aa2","@ga","rew",new Date()));
		list.add(new Member (3,"aa3","@ga","rew",new Date()));
		list.add(new Member (4,"aa4","@ga","rew",new Date()));
		list.add(new Member (5,"aa5","@ga","rew",new Date()));
			
		return list;
	}
	
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public Member getMember() {
	
		Member member = new Member();
		member.setId(1);
		member.setName("Cool");
		member.setEmail("cool@gmail");
		member.setPhoto("default.png");
		
		return member;
		
	}
	
	@RequestMapping("/membermap")
	public Map<Integer, Member> getMap(){
		
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		
		map.put(1, new Member (1,"a1a1","@ga","rew",new Date()));
		map.put(2, new Member (2,"a2a2","@ga","rew",new Date()));
		map.put(3,new Member (3,"a3a3","@ga","rew",new Date()));
		map.put(4,new Member (4,"a4a4","@ga","rew",new Date()));
		map.put(5,new Member (5,"a5a5","@ga","rew",new Date()));
			
		return map;
	}
	

	@RequestMapping("/text")  // /rest/v1/text
	public String testString() {
		return "Hello~ RestFul";
	}
	
}