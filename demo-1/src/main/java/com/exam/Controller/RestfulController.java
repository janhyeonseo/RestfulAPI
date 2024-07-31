package com.exam.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.guestbook.GuestBookVO;
import com.example.guestbook.guestBookservice;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Restful")
@CrossOrigin(origins="*", allowedHeaders="*")
public class RestfulController {
	
	@Autowired
	guestBookservice service;
	
	@GetMapping(value="list", produces="application/json; charset=UTF-8")
	public String Restful(GuestBookVO vo, Model model) {
		System.out.println("==> list");

		int start = 0;
		
		int totalCount = service.totalcount(vo);
		if (vo.getStart() ==0) {
			start = 1 ;
		}else {
			start = vo.getStart();
		}
		
		vo.setStart(start);
		vo.setEnd(totalCount);
		model.addAttribute("li", service.list(vo));
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("totalCount", totalCount);
		resultMap.put("li", service.list(vo));
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(resultMap);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "guestBook/list.html";
	}
}
