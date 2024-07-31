package com.example.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	List<BoardVO> getBoardList(String ch1, String ch2);
	void insert(BoardVO vo);
	void update(BoardVO vo);
	void delete(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	
	int totalCount(BoardVO vo);
}
