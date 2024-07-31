package com.exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.BoardService;
import com.example.board.BoardVO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/board")
@Controller
public class BoardController {
	BoardController(){
		System.out.println("==> BoardController");
	}
	@Autowired
	private BoardService service;

	@GetMapping("/form")
	private String form() {
		return "board/form.html";
	}
	
	
	@GetMapping("/insert")
	private String insert(BoardVO vo, Model model, HttpSession session) {
		System.out.println("===> insert 매핑확인 ");
		int totalCount = service.insert(vo);
		model.addAttribute("totalCount",totalCount);
		return "redirect:/board/getBoardList";
	}
	
	@GetMapping("/getBoardList")
	private String getBoardList(Model model,
			  @RequestParam(value="ch1", defaultValue="name", required=false) String ch1
            , @RequestParam(value="ch2", defaultValue="", required=false)  String ch2 ) {
		System.out.println("===> getBoardList 매핑확인 ");
		System.out.println("확인용"+service.getBoardList(ch1, ch2));

		model.addAttribute("li",service.getBoardList(ch1, ch2));
		return "board/getBoardList.html";
	}
	
	@GetMapping("/getBoard")
	private String getBoard(BoardVO vo, Model model) {
		System.out.println("===> getBoard 매핑확인 "+vo);
		model.addAttribute("m",service.getBoard(vo));
		return "board/getBoard.html";
	}
	
	@GetMapping("/update")
	private String update(BoardVO vo, Model model) {
		System.out.println("===> update 매핑확인 vo"+vo);
		service.update(vo);
		return "redirect:/board/getBoardList";
	}
	
	@GetMapping("/delete")
	private String delete(BoardVO vo, Model model) {
		System.out.println("===> delete 매핑확인 vo"+vo);
		service.delete(vo);
		return "redirect:/board/getBoardList";
	}
}
