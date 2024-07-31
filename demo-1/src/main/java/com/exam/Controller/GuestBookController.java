package com.exam.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guestbook.GuestBookVO;
import com.example.guestbook.guestBookservice;

@RequestMapping("/guestBook")
@Controller
public class GuestBookController {
	GuestBookController() {
		System.out.println("==> GuestBookController");
	}

	@Autowired
	guestBookservice service;

	@GetMapping("insert")
	public String insert(GuestBookVO vo) {
		System.out.println("==> insert");

		String[] firstname = { "하나", "둘", "셋", "넷", "다섯", "여섯", "일곱", "여덜", "아홉" };
		String[] lastname = { "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		int[] age = { 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		String[] memo = { "감사합니다", "잘 부탁드려요", "응원합니다", "정말 감사합니다", "항상 응원해요", "화이팅!", "힘내세요", "안녕하세요", "좋습니다" };

		Random random = new Random();

		for (int i = 0; i < 125; i++) {
			int firstnamearr = random.nextInt(9);
			int lastnamearr = random.nextInt(9);
			int agearr = random.nextInt(9);
			int memoarr = random.nextInt(9);

			vo.setName(firstname[firstnamearr] + lastname[lastnamearr]);
			vo.setMemo(memo[memoarr]);
			vo.setAge(age[agearr]);
			service.insert(vo);
		}

		return "guestBook/list.html";
	}

	@GetMapping("list")
	public String list(GuestBookVO vo, Model model) {
		System.out.println("==> list");

		int start = 0;
		int pageSize = 10;
		int pageListSize = 10;
		
		int totalCount = service.totalcount(vo);
		if (vo.getStart() ==0) {
			start = 1 ;
		}else {
			start = vo.getStart();
		}
		
		int  end = start + pageSize - 1 ;
		int  totalPage =(int) (Math.ceil((double) totalCount / pageSize));  // 전체페이지 수 
		int  currentPage = (start / pageSize) + 1;  // 현재페이지 
		
		int  lastPage = (totalPage - 1) * pageSize + 1;  // 마지막 페이지
		
	    int  listStartPage = (currentPage - 1) / pageListSize * pageListSize + 1;   // 하단 번호 시작
	    int  listEndPage = listStartPage + pageListSize - 1;   // 하단 번호 끝
		
	    // 1. 페이지 사이즈
	    model.addAttribute("pageSize", pageSize);
	    // 2. 페이지 list 사이즈
	    model.addAttribute("pageListSize", pageListSize);
	    // 3. 전체레코드 수
	    model.addAttribute("totalCount", totalCount);
	    // 4. 총페이지 수
	    model.addAttribute("totalPage", totalPage);
	    // 5. 현재레코드 
	    model.addAttribute("start", start);
	    // 6. 현재 페이지:
	    model.addAttribute("currentPage", currentPage);
	    // 7. 하단 가로 시작:
	    model.addAttribute("listStartPage", listStartPage);
	    // 8. 하단 가로 끝 :
	    model.addAttribute("listEndPage", listEndPage);
	    
	    model.addAttribute("lastPage", lastPage);
		
		vo.setStart(start);
		vo.setEnd(end);
		model.addAttribute("li", service.list(vo));

		return "guestBook/list.html";
	}
	
}
