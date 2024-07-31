package com.exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exam.ExamService;
import com.example.exam.ExamVO;

@RequestMapping("/exam")
@Controller
public class ExamController {
	
	ExamController(){
		System.out.println("==> ExamController");
	}
	@Autowired
	ExamService service;
	
	@GetMapping("/getExamList")
	private String getExamList(Model model, ExamVO vo) {
		System.out.println("==> getExamList ");
		model.addAttribute("li", service.getExamList(vo));
		return "exam/getExamList.html";
	}
}
