package com.exam.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.portoneT.PortOneTService;
import com.example.portoneT.PortOneTVO;

@RequestMapping("/PortOneT")
@Controller
public class PortOneTController {
	PortOneTController() {
		System.out.println("==> PortOneTController");
	}
	
	@Autowired
	PortOneTService service;

	PortOneTVO vo1 = new PortOneTVO();	
	
	@GetMapping("/start")
	public String start(PortOneTVO vo, Model model) {
		vo.setGname("지헬스클럽");
		vo.setGymnum(90001);
		vo.setMmail("6963jj@naver.com");
		vo.setMname("참치");
		vo.setMphone("01038516963");
		vo.setMembernum("10001");

		Date d =new  Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyy년M월dd일");
		System.out.println(f.format(d));
		
		vo.setDataName("3개월무료사용");
		vo.setDataPrice(100);
		vo.setDataGoodsnum("70001");		
		vo.setToday(f.format(d));
		
		model.addAttribute("m", vo);
		System.out.println("===> 결제시작하기 ");

		return "PortOneT/start.html";
	}

	@ResponseBody
	@PostMapping("/insertMPay") // @RequestBody 비동기 통신의 값을 요청하기 위해서는 필수 (중요)
	public String insertMPay(@RequestBody PortOneTVO vo, Model model) {
		System.out.println("===> insert 확인 " + vo);
		String OK = service.insert(vo);
		vo1.setMpaynum(vo.getMpaynum());
		System.out.println("===> OK 확인 " + OK+vo.getMpaynum());
		return OK;
	}

	@GetMapping("/result")
	public String result(Model model,  PortOneTVO vo) {
		model.addAttribute("vo1", vo1);
		model.addAttribute("vo2", service.selectf(vo));
		System.out.println("===> result 확인 ");
		return "PortOneT/result.html";
	}
	
	@GetMapping("/failurl")
	public String failurl(Model model) {
		model.addAttribute("hello", "failurl");
		System.out.println("===> failurl 확인 ");
		return "PortOneT/failurl.html";
	}
}
