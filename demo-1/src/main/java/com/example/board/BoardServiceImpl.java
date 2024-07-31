package com.example.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	BoardServiceImpl(){
		System.out.println("==> BoardServiceImpl");
	}
	
	@Autowired
	private BoardDao dao;


	@Override
	public int insert(BoardVO vo) {
		System.out.println("insert==>"+vo);
		dao.insert(vo);
		return dao.totalCount(vo);
		
	}


	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		// TODO Auto-generated method stub
		return dao.getBoardList(ch1, ch2);
	}


	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.getBoard(vo);
	}


	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}


	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
		
	}
}
